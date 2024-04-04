package com.webapp.bankingportal.service;

import java.util.Date;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.webapp.bankingportal.entity.Account;
import com.webapp.bankingportal.entity.Transaction;
import com.webapp.bankingportal.entity.User;
import com.webapp.bankingportal.enums.TransactionType;
import com.webapp.bankingportal.exception.InsufficientBalanceException;
import com.webapp.bankingportal.exception.NotFoundException;
import com.webapp.bankingportal.exception.UnauthorizedException;
import com.webapp.bankingportal.repository.AccountRepository;
import com.webapp.bankingportal.repository.TransactionRepository;

@Service
public class AccountServiceImpl implements AccountService {

    private static final Logger logger = LogManager.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Method to create a new account for a user
    @Override
    public Account createAccount(User user) {
        // Generating a unique account number
        String accountNumber = generateUniqueAccountNumber();
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setBalance(0.0);
        account.setUser(user);
        Account createdAccount = accountRepository.save(account);
        logger.info("Account created successfully with account number: {}", createdAccount.getAccountNumber());
        return createdAccount;
    }

    // Method to check if PIN is created for a given account
    @Override
    public boolean isPinCreated(String accountNumber) {
        Account account = getAccountByAccountNumber(accountNumber);
        boolean pinCreated = account.getPin() != null;
        logger.info("PIN status for account {}: {}", accountNumber, pinCreated ? "Created" : "Not Created");
        return pinCreated;
    }

    // Method to generate a unique account number
    private String generateUniqueAccountNumber() {
        String accountNumber;
        do {
            Random random = new Random();
            int accountNumberInt = random.nextInt(900000000) + 100000000; // 9 digits
            accountNumber = String.valueOf(accountNumberInt);
        } while (accountRepository.findByAccountNumber(accountNumber) != null);
        return accountNumber;
    }

    // Method to create a PIN for an account
    @Override
    public void createPIN(String accountNumber, String password, String pin) {
        Account account = getAccountByAccountNumber(accountNumber);
        validatePassword(account, password);
        account.setPin(passwordEncoder.encode(pin));
        accountRepository.save(account);
        logger.info("PIN created successfully for account: {}", accountNumber);
    }

    // Method to update PIN for an account
    @Override
    public void updatePIN(String accountNumber, String oldPIN, String password, String newPIN) {
        Account account = getAccountByAccountNumber(accountNumber);
        validatePIN(account, oldPIN);
        validatePassword(account, password);
        account.setPin(passwordEncoder.encode(newPIN));
        accountRepository.save(account);
        logger.info("PIN updated successfully for account: {}", accountNumber);
    }

    // Method to deposit cash into an account
    @Override
    public void cashDeposit(String accountNumber, String pin, double amount) {
        Account account = getAccountByAccountNumber(accountNumber);
        validatePIN(account, pin);
        double newBalance = account.getBalance() + amount;
        updateAccountBalance(account, newBalance);
        saveTransaction(account, amount, TransactionType.CASH_DEPOSIT);
        logger.info("Cash deposit of {} into account {} successful", amount, accountNumber);
    }

    // Method to withdraw cash from an account
    @Override
    public void cashWithdrawal(String accountNumber, String pin, double amount) {
        try {
            Account account = getAccountByAccountNumber(accountNumber);
            validatePIN(account, pin);
            double currentBalance = account.getBalance();
            if (currentBalance < amount) {
                throw new InsufficientBalanceException("Insufficient balance");
            }
            double newBalance = currentBalance - amount;
            updateAccountBalance(account, newBalance);
            saveTransaction(account, amount, TransactionType.CASH_WITHDRAWAL);
            logger.info("Cash withdrawal of {} from account {} successful", amount, accountNumber);
        } catch (InsufficientBalanceException e) {
            logger.error("Cash withdrawal failed from account {}: {}", accountNumber, e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Error occurred during cash withdrawal from account {}: {}", accountNumber, e.getMessage());
            throw e;
        }
    }

    // Method to transfer funds between accounts
    @Override
    public void fundTransfer(String sourceAccountNumber, String targetAccountNumber, String pin, double amount) {
        Account sourceAccount = getAccountByAccountNumber(sourceAccountNumber);
        validatePIN(sourceAccount, pin);
        double sourceBalance = sourceAccount.getBalance();
        if (sourceBalance < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        Account targetAccount = getAccountByAccountNumber(targetAccountNumber);
        double newSourceBalance = sourceBalance - amount;
        double newTargetBalance = targetAccount.getBalance() + amount;
        updateAccountBalance(sourceAccount, newSourceBalance);
        updateAccountBalance(targetAccount, newTargetBalance);
        saveTransaction(sourceAccount, targetAccount, amount);
        logger.info("Fund transfer of {} from account {} to account {} successful", amount, sourceAccountNumber, targetAccountNumber);
    }

    // Method to retrieve an account by its account number
    private Account getAccountByAccountNumber(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new NotFoundException("Account not found");
        }
        return account;
    }

    // Method to validate user password
    private void validatePassword(Account account, String password) {
        if (!passwordEncoder.matches(password, account.getUser().getPassword())) {
            throw new UnauthorizedException("Invalid password");
        }
    }

    // Method to validate PIN
    private void validatePIN(Account account, String pin) {
        if (!passwordEncoder.matches(pin, account.getPin())) {
            throw new UnauthorizedException("Invalid PIN");
        }
    }

    // Method to update account balance
    private void updateAccountBalance(Account account, double newBalance) {
        account.setBalance(newBalance);
        accountRepository.save(account);
    }

    // Method to save transaction
    private void saveTransaction(Account account, double amount, TransactionType transactionType) {
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setTransactionType(transactionType);
        transaction.setTransaction_date(new Date());
        transaction.setSourceAccount(account);
        transactionRepository.save(transaction);
        logger.info("Transaction recorded: {} of {} from account {}", transactionType, amount, account.getAccountNumber());
    }

    // Method to save transaction for fund transfer
    private void saveTransaction(Account sourceAccount, Account targetAccount, double amount) {
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setTransactionType(TransactionType.CASH_TRANSFER);
        transaction.setTransaction_date(new Date());
        transaction.setSourceAccount(sourceAccount);
        transaction.setTargetAccount(targetAccount);
        transactionRepository.save(transaction);
        logger.info("Transaction recorded: Cash transfer of {} from account {} to account {}", amount, sourceAccount.getAccountNumber(), targetAccount.getAccountNumber());
    }
}

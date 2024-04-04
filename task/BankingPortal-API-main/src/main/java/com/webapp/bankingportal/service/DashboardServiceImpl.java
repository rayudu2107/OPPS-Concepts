package com.webapp.bankingportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.bankingportal.dto.AccountResponse;
import com.webapp.bankingportal.dto.UserResponse;
import com.webapp.bankingportal.entity.Account;
import com.webapp.bankingportal.entity.User;
import com.webapp.bankingportal.exception.NotFoundException;
import com.webapp.bankingportal.repository.AccountRepository;
import com.webapp.bankingportal.repository.UserRepository;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    // Retrieves user details based on the provided account number.
    @Override
    public UserResponse getUserDetails(String accountNumber) {
        // Retrieve user information from the database based on the account number
        User user = userRepository.findByAccountAccountNumber(accountNumber);
        
        // Check if user exists, otherwise throw NotFoundException
        if (user == null) {
            throw new NotFoundException("User not found for the provided account number.");
        }

        // Map user details to UserResponse DTO
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());
        userResponse.setAddress(user.getAddress());
        userResponse.setPhone_number(user.getPhone_number());
        userResponse.setAccountNumber(user.getAccount().getAccountNumber());
        userResponse.setAccount_type(user.getAccount().getAccount_type());
        userResponse.setBranch(user.getAccount().getBranch());
        userResponse.setIFSC_code(user.getAccount().getIFSC_code());
        return userResponse;
    }

    // Retrieves account details based on the provided account number.
    @Override
    public AccountResponse getAccountDetails(String accountNumber) {
        // Retrieve account information from the database based on the account number
        Account account = accountRepository.findByAccountNumber(accountNumber);
        
        // Check if account exists, otherwise throw NotFoundException
        if (account == null) {
            throw new NotFoundException("Account not found for the provided account number.");
        }

        // Map account details to AccountResponse DTO
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setAccountNumber(account.getAccountNumber());
        accountResponse.setAccountType(account.getAccount_type());
        accountResponse.setBalance(account.getBalance());
        accountResponse.setBranch(account.getBranch());
        accountResponse.setIFSCCode(account.getIFSC_code());

        return accountResponse;
    }
}

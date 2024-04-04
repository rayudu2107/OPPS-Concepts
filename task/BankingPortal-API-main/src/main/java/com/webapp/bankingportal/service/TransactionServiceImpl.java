package com.webapp.bankingportal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.bankingportal.dto.TransactionDTO;
import com.webapp.bankingportal.entity.Transaction;
import com.webapp.bankingportal.mapper.TransactionMapper;
import com.webapp.bankingportal.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	private static final Logger logger = LoggerFactory.getLogger(TransactionServiceImpl.class);

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private TransactionMapper transactionMapper;

	// Retrieves all transactions associated with the given account number.
	@Override
	public List<TransactionDTO> getAllTransactionsByAccountNumber(String accountNumber) {
		logger.info("Fetching all transactions for account number: {}", accountNumber);

		// Retrieve transactions from the repository based on the account number
		List<Transaction> transactions = transactionRepository
				.findBySourceAccount_AccountNumberOrTargetAccount_AccountNumber(accountNumber, accountNumber);

		logger.info("Found {} transactions for account number: {}", transactions.size(), accountNumber);

		// Map transaction entities to TransactionDTO objects and sort them by
		// transaction date
		List<TransactionDTO> transactionDTOs = transactions.stream().map(transactionMapper::toDto)
				.sorted((t1, t2) -> t2.getTransaction_date().compareTo(t1.getTransaction_date()))
				.collect(Collectors.toList());

		logger.info("Returning {} transactions for account number: {}", transactionDTOs.size(), accountNumber);

		return transactionDTOs;
	}
}

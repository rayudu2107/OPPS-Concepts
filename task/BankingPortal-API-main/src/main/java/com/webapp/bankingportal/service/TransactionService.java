package com.webapp.bankingportal.service;

import java.util.List;

import com.webapp.bankingportal.dto.TransactionDTO;
/**
 * This interface defines the operations related to retrieving transactions.
 */
public interface TransactionService {

	List<TransactionDTO> getAllTransactionsByAccountNumber(String accountNumber);

}

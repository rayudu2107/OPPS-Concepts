package com.webapp.bankingportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.bankingportal.entity.Transaction;

// Repository interface for managing Transaction entities in the database.
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Retrieves transactions by either source account number or target account number.
    List<Transaction> findBySourceAccount_AccountNumberOrTargetAccount_AccountNumber(String sourceAccountNumber, String targetAccountNumber);
}

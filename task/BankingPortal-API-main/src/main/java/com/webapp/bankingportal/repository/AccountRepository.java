package com.webapp.bankingportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.bankingportal.entity.Account;

// Repository interface for managing Account entities in the database.
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // Retrieves an account by its account number.
    Account findByAccountNumber(String accountNumber);
}

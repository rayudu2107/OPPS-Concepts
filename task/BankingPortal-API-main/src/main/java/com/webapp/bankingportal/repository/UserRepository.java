package com.webapp.bankingportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webapp.bankingportal.entity.User;

// Repository interface for managing User entities in the database.
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Retrieves a user by email.
    User findByEmail(String email);

    // Retrieves a user by associated account number.
    User findByAccountAccountNumber(String accountNumber);
}

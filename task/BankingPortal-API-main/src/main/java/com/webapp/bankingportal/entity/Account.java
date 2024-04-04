package com.webapp.bankingportal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class representing a bank account.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    // Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Unique account number
    @Column(unique = true)
    private String accountNumber;

    // Current balance of the account
    private double balance;

    // Account type (defaulted to "Saving")
    private String account_type = "Saving";

    // Branch associated with the account (defaulted to "SBI MAIN BRANCH BELLARY")
    private String branch = "SBI MAIN BRANCH BELLARY";

    // IFSC code of the bank branch (defaulted to "SBICAC13200")
    private String IFSC_code = "SBICAC13200";

    // PIN associated with the account
    private String pin;

    // User associated with the account
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}

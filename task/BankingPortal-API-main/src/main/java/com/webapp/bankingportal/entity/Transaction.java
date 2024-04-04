package com.webapp.bankingportal.entity;

import java.util.Date;
import com.webapp.bankingportal.enums.TransactionType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class representing a transaction.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    // Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Transaction amount
    private double amount;

    // Enumerated transaction type (e.g., DEPOSIT, WITHDRAWAL)
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    // Transaction date
    private Date transaction_date;

    // Source account for the transaction
    @ManyToOne
    @JoinColumn(name = "source_account_id")
    private Account sourceAccount;

    // Target account for the transaction
    @ManyToOne
    @JoinColumn(name = "target_account_id")
    private Account targetAccount;
}

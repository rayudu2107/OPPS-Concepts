package com.webapp.bankingportal.dto;

import java.util.Date;

import com.webapp.bankingportal.enums.TransactionType;

import lombok.Getter;
import lombok.Setter;
/**
 * DTO class representing a transaction.
 */
@Getter
@Setter
public class TransactionDTO {
    private Long id; 
    private double amount;
    private TransactionType transaction_type;
    private Date transaction_date;
    private String sourceAccountNumber;
    private String targetAccountNumber;
    
}
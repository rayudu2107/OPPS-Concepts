package com.webapp.bankingportal.dto;

import jakarta.validation.constraints.Digits;
import lombok.Getter;
import lombok.Setter;
/**
 * DTO class representing an amount request.
 */
@Getter
@Setter
public class AmountRequest {
    
    private String pin;

    @Digits(integer = 10, fraction = 0, message = "Amount must be an integer")
    private double amount;
}

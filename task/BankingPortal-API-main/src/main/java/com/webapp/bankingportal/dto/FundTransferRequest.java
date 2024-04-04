package com.webapp.bankingportal.dto;

import jakarta.validation.constraints.Digits;
import lombok.Getter;
import lombok.Setter;
/**
 * DTO class representing a fund transfer request.
 */
@Getter
@Setter
public class FundTransferRequest {
	private String targetAccountNumber;
	@Digits(integer = 10, fraction = 0, message = "Amount must be an integer")
	private double amount;
	private String pin;

}

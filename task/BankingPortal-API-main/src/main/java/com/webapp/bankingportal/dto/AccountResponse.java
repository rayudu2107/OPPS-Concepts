package com.webapp.bankingportal.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO (Data Transfer Object) representing the response for an account. Contains
 * information about an account such as its number, balance, type, branch, and
 * IFSC code.
 */
@Getter
@Setter
public class AccountResponse {
	private String accountNumber;
	private double balance;
	private String accountType;
	private String branch;
	private String IFSCCode;

}

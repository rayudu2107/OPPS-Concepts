package com.webapp.bankingportal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.bankingportal.dto.AccountResponse;
import com.webapp.bankingportal.dto.UserResponse;
import com.webapp.bankingportal.service.DashboardService;
import com.webapp.bankingportal.util.LoggedinUser;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);

	@Autowired
	private DashboardService dashboardService;

	// Retrieves user details from the dashboard service based on the logged-in
	// user's account number.
	@GetMapping("/user")
	public ResponseEntity<UserResponse> getUserDetails() {
		String accountNumber = LoggedinUser.getAccountNumber();
		logger.info("Fetching user details for account number: {}", accountNumber);
		UserResponse userResponse = dashboardService.getUserDetails(accountNumber);
		logger.info("User details fetched successfully for account number: {}", accountNumber);
		return ResponseEntity.ok(userResponse);
	}

	// Retrieves account details from the dashboard service based on the logged-in
	// user's account number.
	@GetMapping("/account")
	public ResponseEntity<AccountResponse> getAccountDetails() {
		String accountNumber = LoggedinUser.getAccountNumber();
		logger.info("Fetching account details for account number: {}", accountNumber);
		AccountResponse accountResponse = dashboardService.getAccountDetails(accountNumber);
		logger.info("Account details fetched successfully for account number: {}", accountNumber);
		return ResponseEntity.ok(accountResponse);
	}
}

package com.webapp.bankingportal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.bankingportal.dto.AmountRequest;
import com.webapp.bankingportal.dto.FundTransferRequest;
import com.webapp.bankingportal.dto.PinRequest;
import com.webapp.bankingportal.dto.PinUpdateRequest;
import com.webapp.bankingportal.dto.TransactionDTO;
import com.webapp.bankingportal.service.AccountService;
import com.webapp.bankingportal.service.TransactionService;
import com.webapp.bankingportal.util.LoggedinUser;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class AccountController {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	@Autowired
	private AccountService accountService;

	@Autowired
	private TransactionService transactionService;

	// Checks if the PIN is created for the logged-in user's account.
	@GetMapping("/pin/check")
	public ResponseEntity<?> checkAccountPIN() {
		logger.info("Checking account PIN for account number: {}", LoggedinUser.getAccountNumber());
		boolean isPINValid = accountService.isPinCreated(LoggedinUser.getAccountNumber());

		Map<String, Object> result = new HashMap<>();
		result.put("hasPIN", isPINValid);
		result.put("msg", isPINValid ? "PIN Created" : "Pin Not Created");

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// Creates a PIN for the logged-in user's account.
	@PostMapping("/pin/create")
	public ResponseEntity<?> createPIN(@Valid @RequestBody PinRequest pinRequest) {
		logger.info("Creating PIN for account number: {}", LoggedinUser.getAccountNumber());
		accountService.createPIN(LoggedinUser.getAccountNumber(), pinRequest.getPassword(), pinRequest.getPin());
		return ResponseEntity.ok(Map.of("msg", "PIN created successfully"));
	}

	// Updates the PIN for the logged-in user's account.
	@PostMapping("/pin/update")
	public ResponseEntity<?> updatePIN(@Valid @RequestBody PinUpdateRequest pinUpdateRequest) {
		logger.info("Updating PIN for account number: {}", LoggedinUser.getAccountNumber());
		accountService.updatePIN(LoggedinUser.getAccountNumber(), pinUpdateRequest.getOldPin(),
				pinUpdateRequest.getPassword(), pinUpdateRequest.getNewPin());
		return ResponseEntity.ok(Map.of("msg", "PIN updated successfully"));
	}

	// Performs a cash deposit for the logged-in user's account.
	@PostMapping("/deposit")
	public ResponseEntity<?> cashDeposit(@Valid @RequestBody AmountRequest amountRequest) {
		logger.info("Performing cash deposit for account number: {}", LoggedinUser.getAccountNumber());
		if (isInvalidAmount(amountRequest.getAmount())) {
			return invalidAmountResponse();
		}
		accountService.cashDeposit(LoggedinUser.getAccountNumber(), amountRequest.getPin(), amountRequest.getAmount());
		return ResponseEntity.ok(Map.of("msg", "Cash deposited successfully"));
	}

	// Performs a cash withdrawal for the logged-in user's account.
	@PostMapping("/withdraw")
	public ResponseEntity<?> cashWithdrawal(@Valid @RequestBody AmountRequest amountRequest) {
		logger.info("Performing cash withdrawal for account number: {}", LoggedinUser.getAccountNumber());
		if (isInvalidAmount(amountRequest.getAmount())) {
			return invalidAmountResponse();
		}
		accountService.cashWithdrawal(LoggedinUser.getAccountNumber(), amountRequest.getPin(),
				amountRequest.getAmount());
		return ResponseEntity.ok(Map.of("msg", "Cash withdrawn successfully"));
	}

	// Performs a fund transfer from the logged-in user's account to another
	// account.
	@PostMapping("/fund-transfer")
	public ResponseEntity<?> fundTransfer(@Valid @RequestBody FundTransferRequest fundTransferRequest) {
		logger.info("Performing fund transfer for account number: {}", LoggedinUser.getAccountNumber());
		if (isInvalidAmount(fundTransferRequest.getAmount())) {
			return invalidAmountResponse();
		}
		accountService.fundTransfer(LoggedinUser.getAccountNumber(), fundTransferRequest.getTargetAccountNumber(),
				fundTransferRequest.getPin(), fundTransferRequest.getAmount());
		return ResponseEntity.ok(Map.of("msg", "Fund transferred successfully"));
	}

	// Retrieves all transactions for the logged-in user's account.
	@GetMapping("/transactions")
	public ResponseEntity<List<TransactionDTO>> getAllTransactionsByAccountNumber() {
		logger.info("Fetching all transactions for account number: {}", LoggedinUser.getAccountNumber());
		List<TransactionDTO> transactions = transactionService
				.getAllTransactionsByAccountNumber(LoggedinUser.getAccountNumber());
		logger.info("Fetched {} transactions for account number: {}", transactions.size(),
				LoggedinUser.getAccountNumber());
		return ResponseEntity.ok(transactions);
	}

	private boolean isInvalidAmount(double amount) {
		return amount <= 0;
	}

	private ResponseEntity<Map<String, String>> invalidAmountResponse() {
		return ResponseEntity.badRequest().body(Map.of("Error", "Invalid amount"));
	}
}

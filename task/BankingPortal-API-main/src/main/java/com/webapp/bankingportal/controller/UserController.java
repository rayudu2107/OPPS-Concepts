package com.webapp.bankingportal.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.bankingportal.dto.LoginRequest;
import com.webapp.bankingportal.dto.UserResponse;
import com.webapp.bankingportal.dto.UserUpdate;
import com.webapp.bankingportal.entity.User;
import com.webapp.bankingportal.security.JwtTokenUtil;
import com.webapp.bankingportal.service.UserService;
import com.webapp.bankingportal.util.LoggedinUser;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	private final AuthenticationManager authenticationManager;
	private final JwtTokenUtil jwtTokenUtil;
	private final UserDetailsService userDetailsService;
	private final UserService userService;

	public UserController(UserService userService, AuthenticationManager authenticationManager,
			JwtTokenUtil jwtTokenUtil, UserDetailsService userDetailsService) {
		this.userService = userService;
		this.authenticationManager = authenticationManager;
		this.jwtTokenUtil = jwtTokenUtil;
		this.userDetailsService = userDetailsService;
	}

	// Registers a new user.
	@PostMapping("/register")
	public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody User user) {
		logger.info("Registering user: {}", user.getName());
		User registeredUser = userService.registerUser(user);

		UserResponse userResponse = new UserResponse();
		userResponse.setName(registeredUser.getName());
		userResponse.setEmail(registeredUser.getEmail());
		userResponse.setAddress(registeredUser.getAddress());
		userResponse.setPhone_number(registeredUser.getPhone_number());
		userResponse.setAccountNumber(registeredUser.getAccount().getAccountNumber());
		userResponse.setIFSC_code(registeredUser.getAccount().getIFSC_code());
		userResponse.setBranch(registeredUser.getAccount().getBranch());
		userResponse.setAccount_type(registeredUser.getAccount().getAccount_type());

		logger.info("User registered successfully: {}", registeredUser.getName());
		return ResponseEntity.ok(userResponse);
	}

	// Logs in a user.
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
		logger.info("Attempting login for account number: {}", loginRequest.getAccountNumber());
		try {
			// Authenticate the user with the account number and password
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getAccountNumber(),
					loginRequest.getPassword()));
		} catch (BadCredentialsException e) {
			// Invalid credentials, return 401 Unauthorized
			logger.error("Invalid credentials for account number: {}", loginRequest.getAccountNumber());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid account number or password");
		}

		// If authentication successful, generate JWT token
		UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getAccountNumber());
		logger.info("User authenticated successfully: {}", loginRequest.getAccountNumber());
		String token = jwtTokenUtil.generateToken(userDetails);
		Map<String, String> result = new HashMap<>();
		result.put("token", token);
		// Return the JWT token in the response
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// Updates user details.
	@PostMapping("/update")
	public ResponseEntity<UserResponse> updateUser(@Valid @RequestBody UserUpdate user) {
		logger.info("Updating user details for account number: {}", LoggedinUser.getAccountNumber());
		User updateUser = userService.updateUser(user);

		UserResponse userResponse = new UserResponse();
		userResponse.setName(updateUser.getName());
		userResponse.setEmail(updateUser.getEmail());
		userResponse.setAddress(updateUser.getAddress());
		userResponse.setPhone_number(updateUser.getPhone_number());
		userResponse.setAccountNumber(updateUser.getAccount().getAccountNumber());
		userResponse.setIFSC_code(updateUser.getAccount().getIFSC_code());
		userResponse.setBranch(updateUser.getAccount().getBranch());
		userResponse.setAccount_type(updateUser.getAccount().getAccount_type());

		logger.info("User details updated successfully for account number: {}", LoggedinUser.getAccountNumber());
		return ResponseEntity.ok(userResponse);
	}
}

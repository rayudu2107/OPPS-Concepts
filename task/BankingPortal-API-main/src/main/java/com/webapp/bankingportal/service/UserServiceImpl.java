package com.webapp.bankingportal.service;

import com.webapp.bankingportal.dto.UserUpdate;
import com.webapp.bankingportal.entity.Account;
import com.webapp.bankingportal.entity.User;
import com.webapp.bankingportal.repository.UserRepository;
import com.webapp.bankingportal.util.LoggedinUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	private final UserRepository userRepository;
	private final AccountService accountService;
	private final PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRepository userRepository, AccountService accountService,
			PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.accountService = accountService;
		this.passwordEncoder = passwordEncoder;
	}

    // Retrieves a user based on the account number.
	@Override
	public User getUserByAccountNumber(String account_no) {
		logger.info("Fetching user by account number: {}", account_no);
		return userRepository.findByAccountAccountNumber(account_no);
	}

    // Registers a new user.
	@Override
	public User registerUser(User user) {
		logger.info("Registering new user: {}", user.getName());
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		// Save the user details
		User savedUser = userRepository.save(user);

		// Create an account for the user
		Account account = accountService.createAccount(savedUser);

		savedUser.setAccount(account);
		userRepository.save(savedUser);

		logger.info("User registered successfully. Account number: {}", savedUser.getAccount().getAccountNumber());
		logger.info("User's name: {}", account.getUser().getName());

		return savedUser;
	}

	// Saves user details.
	@Override
	public void saveUser(User user) {
		logger.info("Saving user details: {}", user.getName());
		userRepository.save(user);
	}

	// Updates user information.
	@Override
	public User updateUser(UserUpdate user) {
		logger.info("Updating user details for account number: {}", LoggedinUser.getAccountNumber());
		User existingUser = userRepository.findByAccountAccountNumber(LoggedinUser.getAccountNumber());
		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		existingUser.setAddress(user.getAddress());
		existingUser.setPhone_number(user.getPhone_number());
		return userRepository.save(existingUser);
	}
}

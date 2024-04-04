package com.webapp.bankingportal.service;

import com.webapp.bankingportal.dto.UserUpdate;
import com.webapp.bankingportal.entity.User;

/**
 * This interface defines operations related to user management.
 */
public interface UserService {
	public User registerUser(User user);

	User getUserByAccountNumber(String account_no);

	public void saveUser(User user);

	public User updateUser(UserUpdate user);

}

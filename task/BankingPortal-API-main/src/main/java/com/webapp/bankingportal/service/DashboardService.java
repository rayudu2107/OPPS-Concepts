package com.webapp.bankingportal.service;

import com.webapp.bankingportal.dto.AccountResponse;
import com.webapp.bankingportal.dto.UserResponse;
/**
 * This interface defines the operations related to retrieving user and account details for the dashboard.
 */
public interface DashboardService {
    UserResponse getUserDetails(String accountNumber);
    AccountResponse getAccountDetails(String accountNumber);
}
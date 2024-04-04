package com.webapp.bankingportal.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import com.webapp.bankingportal.exception.NotFoundException;

/**
 * Utility class to retrieve details of the logged-in user.
 */
public class LoggedinUser {

    /**
     * Method to retrieve the account number of the logged-in user.
     * @return The account number of the logged-in user.
     * @throws NotFoundException If the account number is not found in the Security Context.
     */
    public static String getAccountNumber() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            
            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                return userDetails.getUsername();
            }
        }
        throw new NotFoundException("Account number not found in Security Context.");
    }
}

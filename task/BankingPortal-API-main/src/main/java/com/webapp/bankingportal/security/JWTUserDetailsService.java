package com.webapp.bankingportal.security;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.webapp.bankingportal.entity.User;
import com.webapp.bankingportal.repository.UserRepository;

@Service
public class JWTUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // Load user details by account number
    @Override
    public UserDetails loadUserByUsername(String accountNumber) throws UsernameNotFoundException {
        // Find user by account number
        User user = userRepository.findByAccountAccountNumber(accountNumber);
        if (user == null) {
            // Throw exception if user not found
            throw new UsernameNotFoundException("Invalid account number");
        }

        // Return a UserDetails object that wraps the User entity
        return new org.springframework.security.core.userdetails.User(
                user.getAccount().getAccountNumber(),  // Use account number as the username
                user.getPassword(), // User's password
                Collections.emptyList() // No additional roles or authorities
        );
    }   
}

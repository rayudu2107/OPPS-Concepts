package com.webapp.bankingportal.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
/**
 * DTO class representing a login request.
 */
@Getter
@Setter
public class LoginRequest {
    
    @Pattern(regexp = "\\d{9}", message = "Account number must be a 9-digit integer")
    private String accountNumber;
    
    private String password;
}

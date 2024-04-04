package com.webapp.bankingportal.dto;

import lombok.Getter;
import lombok.Setter;
/**
 * DTO class representing the response object for user details.
 */
@Getter
@Setter
public class UserResponse  {
    
    private String name;
    private String email;
    private String address;
    private String phone_number;
    private String accountNumber;
    private String IFSC_code;
    private String branch;
    private String account_type;
  
}

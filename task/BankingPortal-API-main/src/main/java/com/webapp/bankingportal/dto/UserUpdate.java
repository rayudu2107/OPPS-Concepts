package com.webapp.bankingportal.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO class representing user update information.
 */
@Getter
@Setter
public class UserUpdate {
	@Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Invalid name format. Only letters and spaces are allowed.")
	private String name;

	@Column(unique = true) // Ensuring email uniqueness
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format")
	private String email;

	@NotBlank(message = "Address is required")
	@Size(min = 10, max = 35, message = "Address must be between 10 and 35 characters")
	private String address;
	@Pattern(regexp = "\\+?[0-9]{10}", message = "Invalid phone number format. Phone number must be exactly 10 digits")
	private String phone_number;
}

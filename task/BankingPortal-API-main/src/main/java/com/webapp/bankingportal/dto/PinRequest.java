package com.webapp.bankingportal.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
/**
 * DTO class representing a PIN update request.
 */
@Getter
@Setter
public class PinRequest {
	@Pattern(regexp = "\\d{4}", message = "PIN must contain exactly 4 digits")
	private String pin;
	private String password;

}

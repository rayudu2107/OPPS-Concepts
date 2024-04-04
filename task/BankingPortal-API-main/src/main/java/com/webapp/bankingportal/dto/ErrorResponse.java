package com.webapp.bankingportal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents an error response containing a message.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String message;
}

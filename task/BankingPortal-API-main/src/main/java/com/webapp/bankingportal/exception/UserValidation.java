package com.webapp.bankingportal.exception;

import java.io.Serializable;

public class UserValidation extends RuntimeException implements Serializable {
    // Generated serialVersionUID
    private static final long serialVersionUID = 1L;

    public UserValidation(String message) {
        super(message);
    }
}

package com.training.book.exception;

@SuppressWarnings("serial")
public class ActivationTokenException extends RuntimeException {
    public ActivationTokenException(String message) {
        super(message);
    }
}

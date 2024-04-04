package com.webapp.bankingportal.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle NotFoundException and return a 404 Not Found response with the exception message.
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    // Handle UnauthorizedException and return a 401 Unauthorized response with the exception message.
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> handleUnauthorizedException(UnauthorizedException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    // Handle InvalidJwtTokenException and return a 400 Bad Request response with the exception message.
    @ExceptionHandler(InvalidJwtTokenException.class)
    public ResponseEntity<String> handleInvalidJwtTokenException(InvalidJwtTokenException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    // Handle InsufficientBalanceException and return a 400 Bad Request response with the exception message.
    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<String> handleInsufficientBalanceException(InsufficientBalanceException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
    
    // Handle MethodArgumentNotValidException and return a 400 Bad Request response with validation errors.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }
    
    // Handle DataIntegrityViolationException and return a 400 Bad Request response with appropriate error message.
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        Throwable rootCause = ex.getRootCause();
        if (rootCause instanceof SQLIntegrityConstraintViolationException) {
            SQLIntegrityConstraintViolationException sqlEx = (SQLIntegrityConstraintViolationException) rootCause;
            Map<String, String> errors = new HashMap<>();
            errors.put("message", "Duplicate entry for key: " + sqlEx.getMessage());
            return ResponseEntity.badRequest().body(errors);
        } else {
            // Handle other types of DataIntegrityViolationException if needed
            // For now, return a generic error response
            Map<String, String> errors = new HashMap<>();
            errors.put("message", "Data integrity violation");
            return ResponseEntity.badRequest().body(errors);
        }
    }
}

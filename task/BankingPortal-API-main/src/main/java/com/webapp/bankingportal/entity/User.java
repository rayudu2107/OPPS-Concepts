package com.webapp.bankingportal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entity class representing a user in the banking portal.
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    // Primary key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Validating name format
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Invalid name format. Only letters and spaces are allowed.")
    private String name;

    // Validating password format
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", message = "Invalid password format. Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one digit, and one special character.")
    @Column(unique = true)
    private String password;

    // Validating email format and ensuring uniqueness
    @Column(unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format")
    private String email;

    // Validating address length
    @NotBlank(message = "Address is required")
    @Size(min = 10, max = 35, message = "Address must be between 10 and 35 characters")
    private String address;

    // Validating phone number format
    @Pattern(regexp = "\\+?[0-9]{10}", message = "Invalid phone number format. Phone number must be exactly 10 digits")
    private String phone_number;

    // Establishing a one-to-one relationship with the account
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonIgnore
    private Account account;
}

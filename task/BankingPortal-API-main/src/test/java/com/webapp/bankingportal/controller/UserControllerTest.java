package com.webapp.bankingportal.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.webapp.bankingportal.dto.LoginRequest;
import com.webapp.bankingportal.dto.UserResponse;
import com.webapp.bankingportal.dto.UserUpdate;
import com.webapp.bankingportal.entity.Account;
import com.webapp.bankingportal.entity.User;
import com.webapp.bankingportal.security.JwtTokenUtil;
import com.webapp.bankingportal.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Map;

class UserControllerTest {

    private final UserService userService = mock(UserService.class);
    private final AuthenticationManager authenticationManager = mock(AuthenticationManager.class);
    private final JwtTokenUtil jwtTokenUtil = mock(JwtTokenUtil.class);
    private final UserDetailsService userDetailsService = mock(UserDetailsService.class);
    private final UserController userController = new UserController(userService, authenticationManager, jwtTokenUtil, userDetailsService);

    @Test
    void testRegisterUser() {
        // Given
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setAddress("123 Main St");
        user.setPhone_number("+1234567890");
        user.setPassword("password");
        
        Account account = new Account();
        account.setAccountNumber("123456789");
        account.setBalance(0.0);
        account.setAccount_type("Savings");
        account.setBranch("Main Branch");
        account.setIFSC_code("IFSC123");
        account.setPin("1234");
        account.setUser(user);

        user.setAccount(account);

        when(userService.registerUser(any(User.class))).thenReturn(user);

        // When
        ResponseEntity<UserResponse> responseEntity = userController.registerUser(user);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(user.getName(), responseEntity.getBody().getName());
        assertEquals(user.getEmail(), responseEntity.getBody().getEmail());
        assertEquals(user.getAddress(), responseEntity.getBody().getAddress());
        assertEquals(user.getPhone_number(), responseEntity.getBody().getPhone_number());
        assertNotNull(responseEntity.getBody().getAccountNumber());
        assertEquals(account.getAccountNumber(), responseEntity.getBody().getAccountNumber());
        assertEquals(account.getIFSC_code(), responseEntity.getBody().getIFSC_code());
        assertEquals(account.getBranch(), responseEntity.getBody().getBranch());
        assertEquals(account.getAccount_type(), responseEntity.getBody().getAccount_type());
    }

    @Test
    void testUpdateUser() {
        // Given
        UserUpdate userUpdate = new UserUpdate();
        userUpdate.setName("Updated Name");
        userUpdate.setEmail("updated.email@example.com");
        userUpdate.setAddress("456 Elm St");
        userUpdate.setPhone_number("+987654321");

        User updatedUser = new User();
        updatedUser.setName("Updated Name");
        updatedUser.setEmail("updated.email@example.com");
        updatedUser.setAddress("456 Elm St");
        updatedUser.setPhone_number("+987654321");
        
        // Create and associate an Account object
        Account account = new Account();
        account.setAccountNumber("123456789"); // Set the account number
        updatedUser.setAccount(account); // Associate the account with the user

        when(userService.updateUser(any(UserUpdate.class))).thenReturn(updatedUser);

        // When
        ResponseEntity<UserResponse> responseEntity = userController.updateUser(userUpdate);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals(updatedUser.getName(), responseEntity.getBody().getName());
        assertEquals(updatedUser.getEmail(), responseEntity.getBody().getEmail());
        assertEquals(updatedUser.getAddress(), responseEntity.getBody().getAddress());
        assertEquals(updatedUser.getPhone_number(), responseEntity.getBody().getPhone_number());
    }



    @Test
    void testLogin_ValidCredentials() {
        // Given
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setAccountNumber("123456789");
        loginRequest.setPassword("password");

        UserDetails userDetails = mock(UserDetails.class);
        when(userDetailsService.loadUserByUsername(any(String.class))).thenReturn(userDetails);
        when(jwtTokenUtil.generateToken(any(UserDetails.class))).thenReturn("token");

        // When
        ResponseEntity<?> responseEntity = userController.login(loginRequest);

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertTrue(responseEntity.getBody() instanceof Map);
        assertTrue(((Map<?, ?>) responseEntity.getBody()).containsKey("token"));
    }

    @Test
    void testLogin_InvalidCredentials() {
        // Given
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setAccountNumber("123456789");
        loginRequest.setPassword("invalidpassword");

        doThrow(BadCredentialsException.class).when(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));

        // When
        ResponseEntity<?> responseEntity = userController.login(loginRequest);

        // Then
        assertEquals(HttpStatus.UNAUTHORIZED, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        assertEquals("Invalid account number or password", responseEntity.getBody());
    }
}

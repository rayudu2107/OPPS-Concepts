# Banking Portal Rest API Using Spring Boot & Spring Security

  ## API Documentation

**Introduction:**
The Banking Portal API allows users to perform various banking operations, including managing accounts, fund transfers, and transactions. This document provides details on each API endpoint, its request parameters, response structure, and authentication requirements. It also includes information on error handling and status codes.

**Authentication:**
The API endpoints require bearer token authentication. Users must obtain a valid access token and include it in the "Authorization" header with the "Bearer" scheme to access protected endpoints.

**Base URL:**
`http://localhost:8180`

### 1. Account Endpoints

#### 1.1. Check PIN Created
- **Endpoint:** `/api/account/pin/check`
- **Method:** `GET`
- **Authorization:** Bearer Token
- **Request Body:** None
- **Description:** Checks if a PIN has been created for the user's account.
- **Response:**
  - Status Code: 200 OK
  - Body:
    ```json
    {
        "hasPIN": true,
        "msg": "PIN Created"
    }
    ```
    or
    ```json
    {
        "hasPIN": false,
        "msg": "Pin Not Created"
    }
    ```

**Possible Status Codes:**
- 200 OK: The PIN status was successfully retrieved.
- 401 Unauthorized: The user is not authenticated. Please ensure you include a valid bearer token in the request header.

#### 1.2. Create PIN
- **Endpoint:** `/api/account/pin/create`
- **Method:** `POST`
- **Authorization:** Bearer Token
- **Request Body:**
  ```json
  {
      "pin": "1234",
      "password": "secretpassword1"
  }
  ```
- **Description:** Creates a new PIN for the user's account.
- **Response:**
  - Status Code: 200 OK
  - Body:
    ```json
    {
        "msg": "PIN created successfully"
    }
    ```

**Possible Status Codes:**
- 200 OK: The PIN was successfully created.
- 400 Bad Request: The request body is missing or invalid.
- 401 Unauthorized: The user is not authenticated or the provided password is incorrect. Please ensure you include a valid bearer token in the request header.
- 404 Not Found: The user's account was not found.

#### 1.3. Update PIN
- **Endpoint:** `/api/account/pin/update`
- **Method:** `POST`
- **Authorization:** Bearer Token
- **Request Body:**
  ```json
  {
      "oldPin": "4321",
      "newPin": "1234",
      "password": "secretpassword1"
  }
  ```
- **Description:** Updates the existing PIN for the user's account.
- **Response:**
  - Status Code: 200 OK
  - Body:
    ```json
    {
        "msg": "PIN updated successfully"
    }
    ```

**Possible Status Codes:**
- 200 OK: The PIN was successfully updated.
- 400 Bad Request: The request body is missing or invalid.
- 401 Unauthorized: The user is not authenticated, the provided password is incorrect, or the old PIN is incorrect. Please ensure you include a valid bearer token in the request header.
- 404 Not Found: The user's account was not found.

#### 1.4. Withdraw
- **Endpoint:** `/api/account/withdraw`
- **Method:** `POST`
- **Authorization:** Bearer Token
- **Request Body:**
  ```json
  {
      "amount": 10.0,
      "pin": "4321"
  }
  ```
- **Description:** Withdraws the specified amount from the user's account.
- **Response:**
  - Status Code: 200 OK
  - Body:
    ```json
    {
        "msg": "Cash withdrawn successfully"
    }
    ```

**Possible Status Codes:**
- 200 OK: The cash withdrawal was successful.
- 400 Bad Request: The request body is missing or invalid, or the account does not have sufficient balance.
- 401 Unauthorized: The user is not authenticated or the provided PIN is incorrect. Please ensure you include a valid bearer token in the request header.
- 404 Not Found: The user's account was not found.

#### 1.5. Deposit
- **Endpoint:** `/api/account/deposit`
- **Method:** `POST`
- **Authorization:** Bearer Token
- **Request Body:**
  ```json
  {
      "amount": 100.0,
      "pin": "4321"
  }
  ```
- **Description:** Deposits the specified amount into the user's account.
- **Response:**
  - Status Code: 200 OK
  - Body:
    ```json
    {
        "msg": "Cash deposited successfully"
    }
    ```

**Possible Status Codes:**
- 200 OK: The cash deposit was successful.
- 400 Bad Request: The request body is missing or invalid.
- 401 Unauthorized: The user is not authenticated or the provided PIN is incorrect. Please ensure you include a valid bearer token in the request header.
- 404 Not Found: The user's account was not found.

#### 1.6. Fund Transfer
- **Endpoint:** `/api/account/fund-transfer`
- **Method:** `POST`
- **Authorization:** Bearer Token
- **Request Body:**
  ```json
  {
      "amount": 10.0,
      "pin": "4321",
      "targetAccountNumber": "556704"
  }
  ```
- **Description:** Transfers the specified amount to another user's account.
- **Response:**
  - Status Code: 200 OK
  - Body:
    ```json
    {
        "msg": "Fund transferred successfully"
    }
    ```

**Possible Status Codes:**
- 200 OK: The fund transfer was successful.
- 400 Bad Request: The request body is missing or invalid, or the account does not have sufficient balance.
- 401 Unauthorized: The user is not authenticated or the provided PIN is incorrect. Please ensure you include a valid bearer token in the request header.
- 404 Not Found: The user's source or target account was not found.

#### 1.7. Transactions
- **Endpoint:** `/api/account/transactions`
- **Method:** `GET`
- **Authorization:** Bearer Token
- **Description:** Retrieves the list of transactions for the user's account.
- **Response:**
  - Status Code: 200 OK
  - Body: List of transaction objects.

**Possible Status Codes:**
- 200 OK: The list of transactions was successfully retrieved.
- 401 Unauthorized: The user is not authenticated. Please ensure you include a valid bearer token in the request header.

#### 1.8. Account Details
- **Endpoint:** `/api/dashboard/account`
- **Method:** `GET`
- **Authorization:** Bearer Token
- **Description:** Retrieves details of the user's account.
- **Response:**
  - Status Code: 200 OK
  - Body: Account details object.

**Possible Status Codes:**
- 200 OK: The account details were successfully retrieved.
- 401 Unauthorized: The user is not authenticated. Please

 ensure you include a valid bearer token in the request header.
- 404 Not Found: The user's account was not found.

### 2. User Endpoints

#### 2.1. Register User
- **Endpoint:** `/api/users/register`
- **Method:** `POST`
- **Request Body:**
  ```json
  {
      "name": "Abhishek a",
      "password": "secretpassword2",
      "email": "jonoe@gmail.com",
      "address": "123 Main Street",
      "phone_number": "134566690"
  }
  ```
- **Description:** Registers a new user with the provided details.
- **Response:**
  - Status Code: 200 OK
  - Body:
    ```json
    {
        "name": "Abhishek a",
        "email": "jonoe@gmail.com",
        "accountNumber": "236480",
        "IFSC_code": "[IFSC_CODE]",
        "branch": "[BRANCH]",
        "account_type": "[ACCOUNT_TYPE]"
    }
    ```

**Possible Status Codes:**
- 200 OK: The user was successfully registered.
- 400 Bad Request: The request body is missing or invalid.
- 404 Not Found: The user's account was not found.

#### 2.2. Get User Details
- **Endpoint:** `/api/dashboard/user`
- **Method:** `GET`
- **Authorization:** Bearer Token
- **Description:** Retrieves details of the authenticated user.
- **Response:**
  - Status Code: 200 OK
  - Body: User details object.

**Possible Status Codes:**
- 200 OK: The user details were successfully retrieved.
- 401 Unauthorized: The user is not authenticated. Please ensure you include a valid bearer token in the request header.
- 404 Not Found: The user's account was not found.

#### 2.3. Login
- **Endpoint:** `/api/users/login`
- **Method:** `POST`
- **Request Body:**
  ```json
  {
      "accountNumber": "236480",
      "password": "secretpassword2"
  }
  ```
- **Description:** Logs in the user with the provided account number and password.
- **Response:**
  - Status Code: 200 OK
  - Body:
    ```json
    {
        "token": "[JWT_TOKEN]"
    }
    ```

**Possible Status Codes:**
- 200 OK: The login was successful, and a JWT token is provided in the response body.
- 400 Bad Request: The request body is missing or invalid.
- 401 Unauthorized: The provided account number or password is incorrect.
- 404 Not Found: The user's account was not found.

**Error Handling:**
The API implements global exception handling for the following scenarios:
- NotFoundException: Returns 404 Not Found with an error message.
- UnauthorizedException: Returns 401 Unauthorized with an error message.
- InsufficientBalanceException: Returns 400 Bad Request with an error message.

Please note that this API documentation provides an overview of the available endpoints, request parameters, and response structures, along with additional details on error handling and status codes. For a comprehensive understanding of the API, further details such as possible response data and detailed error messages should be included in the final API documentation.

***

The Banking Portal API provides a set of endpoints for managing user accounts, fund transfers, and transactions. This project aims to facilitate secure and efficient banking operations for users.

## Features

- User Registration: Users can register by providing their details, such as name, email, address, and phone number.
- PIN Management: Users can create and update their PINs for added security.
- Cash Deposit and Withdrawal: Users can deposit and withdraw cash from their accounts.
- Fund Transfer: Users can transfer funds to other accounts within the system.
- Transaction History: Users can view their transaction history.

## Technologies Used

<img src="https://github.com/abhi9720/BankingPortal-API/assets/68281476/31896d20-16d9-4fe1-a534-0490841de4b9" alt="image" height="100">
<img src="https://github.com/abhi9720/BankingPortal-API/assets/68281476/c09bc4ac-c0ca-4f7c-9c6e-8eb9818eb35b" alt="image" height="100">
<img src="https://github.com/abhi9720/BankingPortal-API/assets/68281476/78c75fff-e8a8-49c6-9897-34b08b2c9308" alt="image" height="100">
<img src="https://github.com/abhi9720/BankingPortal-API/assets/68281476/3647613e-1d6e-4bc4-98b6-2da5648659f9" alt="image" height="100">
<img src="https://github.com/abhi9720/BankingPortal-API/assets/68281476/8a5c0b00-776b-444e-bc24-36fc6bfe4c41" alt="image" height="50">
<img src="https://github.com/abhi9720/BankingPortal-API/assets/68281476/b56a7167-6a3a-49a0-8b8a-8a4e3e71a383" alt="image" height="70">
<img src="https://github.com/abhi9720/BankingPortal-API/assets/68281476/b5c86e65-cbe8-400a-afeb-895846601da7" alt="image"  height="100">

<!--
- Java Spring Boot Framework
- Spring Security for authentication
- JWT (JSON Web Token) for secure API authentication
- MySQL for data storage
- Hibernate for object-relational mapping
- Maven for project management
- Postman for API testing
-->
  
## Installation and Setup

1. Clone the repository: `git clone https://github.com/yourusername/banking-portal-api.git`
2. Navigate to the project folder: `cd banking-portal-api`
3. Configure MySQL: Set up a MySQL database and update the database credentials in `application.properties`.
4. Build and run the project: `mvn spring-boot:run`


## Error Handling

The API implements global exception handling for common error scenarios, such as account not found, unauthorized access, and insufficient balance.

## How to Contribute

We welcome and encourage developers to contribute to the project and help us make it even better. If you are interested in contributing, follow these steps:

👉🏻**Fork the Repository**: Click on the "Fork" button on the top right corner of the GitHub repository page. This will create a copy of the repository in your GitHub account.

👉🏻**Clone the Forked Repository**: Open your terminal or command prompt and use the following command to clone the repository to your local machine:
   ```
   git clone https://github.com/your-username/BankingPortal-API.git
   ```
   Replace `your-username` with your GitHub username.

👉🏻**Create a New Branch**: Move into the project directory using `cd BankingPortal-API` and create a new branch for your changes:
   ```
   git checkout -b feature/your-new-feature
   ```
   Replace `your-new-feature` with a descriptive name for your contribution.

👉🏻**Make Changes**: Now, make the desired changes to the codebase using your favorite code editor.

👉🏻**Commit Changes**: After making the changes, save your work and commit the changes with a meaningful commit message:
   ```
   git add .
   git commit -m "Add your commit message here"
   ```

👉🏻**Push Changes**: Push your changes to your forked repository:
   ```
   git push origin feature/your-new-feature
   ```

👉🏻**Create a Pull Request**: Go to your forked repository on GitHub, and you'll see a "Compare & Pull Request" button. Click on it to create a new pull request.

👉🏻**Wait for Review**: Your pull request will be reviewed by the project maintainers. Make any necessary changes based on their feedback.

**👏🏻👏🏻 Congratulations! 🎉🎊** Your contribution has been accepted and merged into the main repository. You are now a contributor to the project.

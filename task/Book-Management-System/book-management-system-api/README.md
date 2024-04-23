# Book Management System - Backend

## Overview

The backend of the Book Management System project is responsible for handling all server-side operations, including user authentication, book management, and API endpoints. This section provides an overview of the backend architecture, technologies used, and setup instructions.

## Technologies Used

- **Spring Boot 3**: A powerful framework for building Java-based applications.
- **Spring Security 6**: Provides authentication and authorization mechanisms for securing the application.
- **JWT Token Authentication**: Ensures secure communication between the client and server.
- **Spring Data JPA**: Simplifies data access and persistence using the Java Persistence API.
- **JSR-303 and Spring Validation**: Enables validation of objects based on annotations.
- **OpenAPI and Swagger UI Documentation**: Generates documentation for the API endpoints.

## Setup Instructions

To set up the backend of the Book Management System project, follow these steps:

1. Clone the repository:

```bash
   git clone https://github.com/rayudu2107/book-management-system-api.git
```

2. Navigate to the book-management-system-api directory:

```bash
  cd book-management-system-api
```

3. Install dependencies (assuming Maven is installed):

```bash
  mvn clean install
```

4. Run the application but first replace the `x.x.x` with the current version from the `pom.xml` file

```bash
  java -jar target/book-management-system-api-x.x.x.jar
```

5. Access the API documentation using Swagger UI:

Open a web browser and go to `http://localhost:8088/api/v1/swagger-ui/index.html.

## License

This project is licensed under the Apache License 2.0. See the [LICENSE](/LICENSE) file for details.

## Contributors

- [RAYUDU](https://github.com/rayudu2107)

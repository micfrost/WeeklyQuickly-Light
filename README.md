# WeeklyQuickly

## Description
WeeklyQuickly is an advanced e-commerce web application built using Java and the Spring Framework. It is designed to provide a complete online shopping experience, equipped with user management, product catalog, and shopping cart functionalities.

## Key Features
- **User Role Management**: Distinct roles for Admins, Employees, and Customers.
- **Product Catalog**: Comprehensive management of products and items.
- **Shopping Cart**: Full-fledged shopping cart functionalities including adding, updating, and listing cart items.
- **User Authentication**: Secure login and user authentication system.

## Technologies Used
- **Java**: Leveraged Java for building a robust and scalable backend.
- **Spring Boot**: Utilized for simplified application setup and configuration.
- **Spring Security**: Employed for secure authentication and authorization.
- **Spring Data JPA**: Integrated with databases using Spring Data JPA for efficient data persistence and retrieval.
- **Thymeleaf**: Used for dynamic server-side rendering of HTML views.
- **Bootstrap**: For responsive frontend design.

## Installation
1. Install Java JDK and Maven.
2. Clone this repository.
3. Navigate to the project directory and run `mvn clean install`.
4. Launch the application using `mvn spring-boot:run`.
5. Access the application at `http://localhost:8080`.
6. Login with the default credentials:
   - username: **adminmichal**: `
   - password: **adminmichal**: `

## How to Use
- Navigate to various endpoints such as `/user-list`, `/product-list`, `/cart-list`, etc., to interact with the application.
- Perform operations like adding new users, products, viewing cart items, and more.

## Folder Structure
- `src/main/java/dev/micfro/weeklyquickly`: Main application source files.
- `src/main/resources/templates`: Thymeleaf templates for the frontend.
- `src/main/resources/static`: Static resources like CSS and JavaScript files.

## Author
Created by Michal Frost.
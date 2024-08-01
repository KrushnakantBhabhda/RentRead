RentRead is a book rental system developed using Spring Boot. The application supports user registration and login, book management, and rental management functionalities. It implements Basic Authentication with two roles: USER and ADMIN. The project includes comprehensive error handling, logging, unit testing, and is published to GitHub.

Features
User Registration and Login

Users can register with an email address and password.
Passwords are encrypted and stored using BCrypt.
Fields: Email, Password, First Name, Last Name, Role.
Role defaults to USER if not specified.
Book Management

Store and manage book details.
Fields: Title, Author, Genre, Availability Status.
Only the ADMIN can create, update, and delete books.
Rental Management

Users can rent books.
A user can have up to two active rentals at a time.
Users can return rented books.
API Endpoints
Public Endpoints
POST /register - Register a new user.
POST /login - Login with email and password.
Private Endpoints
Books

GET /books - Get all books (Authenticated users).
GET /books/{id} - Get a book by ID (Authenticated users).
POST /books - Create a new book (ADMIN only).
PUT /books/{id} - Update a book (ADMIN only).
DELETE /books/{id} - Delete a book (ADMIN only).
Rentals

POST /books/{bookId}/rent - Rent a book (Authenticated users).
POST /books/{bookId}/return - Return a rented book (Authenticated users).
Logging and Error Handling
The application includes logging for information and errors, and handles common errors gracefully by returning appropriate HTTP codes (e.g., 404 for user not found).

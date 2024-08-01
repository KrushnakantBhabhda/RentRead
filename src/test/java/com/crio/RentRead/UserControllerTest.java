package com.crio.RentRead;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.crio.RentRead.Controller.BookController;
import com.crio.RentRead.Controller.UserController;
import com.crio.RentRead.Entity.Book;
import com.crio.RentRead.Entity.User;
import com.crio.RentRead.Model.LoginRequest;
import com.crio.RentRead.Services.AuthService;
import com.crio.RentRead.Services.BookService;
import com.crio.RentRead.Services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @Mock
    private AuthService authService;

    @InjectMocks
    private UserController userController;

    @Test
    public void test_registers_new_user_with_unique_email() {
        User user = new User();
        user.setEmail("unique@example.com");

        when(userService.loadUserByUsername(user.getEmail())).thenReturn(null);
        when(authService.register(user)).thenReturn(user);

        ResponseEntity<User> response = userController.register(user);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

    @Test
    public void test_successful_login_with_valid_email_and_password() {
        // Arrange
        String email = "valid@example.com";
        String password = "validPassword";
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
    
        when(authService.login(email, password)).thenReturn(user);
    
        // Act
        LoginRequest loginRequest= new LoginRequest(email,password);
        ResponseEntity<User> response = userController.login(loginRequest);
    
        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(user, response.getBody());
    }

     @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

    @Test
    public void returns_list_of_books_when_books_are_available() {
        // Arrange
        Book b= new Book(null, "Book 1", null, null, false, null);
        Book c = new Book(null, "Book 2", null, null, false, null);
        List<Book> books = Arrays.asList(b,c);
        when(bookService.getAllBooks()).thenReturn(books);
    
        // Act
        ResponseEntity<List<Book>> response = bookController.getAllBooks();
    
        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(books, response.getBody());
    }
}

package com.crio.RentRead.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crio.RentRead.Entity.User;
import com.crio.RentRead.Services.AuthService;
import com.crio.RentRead.Services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {


     @Autowired
     UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthService authService;





    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody  User user) {
        if (userService.loadUserByUsername(user.getEmail())!=null) {
            throw new RuntimeException("Email is already in use");
        }

        
        return ResponseEntity.ok(authService.register(user));
    }



    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String email, @RequestParam String password) {
        return ResponseEntity.ok(authService.login(email,password));
        
       
    }
    
}

package com.crio.RentRead.Services;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.crio.RentRead.Entity.Role;
import com.crio.RentRead.Entity.User;
import com.crio.RentRead.Repository.UserRepository;


@Service
public class AuthService {

    //  private static final Logger logger = (Logger) LoggerFactory.getLogger(AuthService.class);


    @Autowired
    PasswordEncoder  passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    public User register(User user) {
        if (user.getRole() == null) {
            user.setRole(Role.USER);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Ensure password is encoded
        return userRepository.save(user);

    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        // logger.info("Attempting to log in user with email: {}", email);
        if(user==null){
            // logger.error("User not found with email: {}", email);
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
if (passwordEncoder.matches(password, user.getPassword())) {
    // logger.info("Login successful for user with email: {}", email);
    return user;
} else {
    // logger.error("Invalid password for user with email: {}", email);
    throw new BadCredentialsException("Invalid password");
}

    }
}

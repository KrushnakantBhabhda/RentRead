package com.crio.RentRead.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.crio.RentRead.Entity.Role;
import com.crio.RentRead.Entity.User;
import com.crio.RentRead.Repository.UserRepository;


@Service
public class AuthService {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    public User register(User user) {
        if (user.getRole() == null) {
            user.setRole(Role.USER);
        }

        return userRepository.save(user);

    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            if (passwordEncoder.matches(password, user.getPassword())) {
                return user;
            } else {
                throw new BadCredentialsException("Invalid password");
            }
        }

        return user;

    }
}

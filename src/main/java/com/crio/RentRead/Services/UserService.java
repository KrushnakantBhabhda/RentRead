package com.crio.RentRead.Services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crio.RentRead.Entity.Role;
import com.crio.RentRead.Entity.User;
import com.crio.RentRead.Repository.UserRepository;

@Service
public class UserService implements UserDetailsService {



    @Autowired
    UserRepository userRepository;

    @Override
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email);
    }

   



    
    


    
}

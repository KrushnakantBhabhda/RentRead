package com.crio.RentRead.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.crio.RentRead.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);

    




    
} 
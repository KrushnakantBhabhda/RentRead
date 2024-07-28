package com.crio.RentRead.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crio.RentRead.Entity.Rental;
import com.crio.RentRead.Entity.User;

@Repository
public interface RentalRepository extends JpaRepository<Rental,Long>{
    List<Rental> findByUserAndReturnDateIsNull(User user);
    
}

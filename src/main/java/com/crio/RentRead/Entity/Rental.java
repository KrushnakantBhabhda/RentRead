package com.crio.RentRead.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Entity
@Data
public class Rental {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long rentalId;

    @ManyToOne
    @JoinColumn(name = "user_id")
   
    User user ;
  
    @ManyToOne
    @JoinColumn(name = "book_id")
    Book book;

    LocalDateTime rentalDate;
    LocalDateTime returnDate;
    
}

package com.crio.RentRead.Controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crio.RentRead.Entity.Book;
import com.crio.RentRead.Entity.Rental;
import com.crio.RentRead.Entity.User;
import com.crio.RentRead.Services.RentalService;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@RestController
@RequestMapping("/books")
public class RentalController {

     @Autowired
    private RentalService rentalService;

    @PostMapping("/{bookId}/rent")
    public ResponseEntity<Rental> rentBook(@RequestParam Long userId, @RequestParam Long bookId) {
        return ResponseEntity.ok(rentalService.rentBook(userId, bookId));
    }

    @PostMapping("/{rentalId}/return")
    public ResponseEntity<Rental> returnBook(@PathVariable Long rentalId) {
        return ResponseEntity.ok(rentalService.returnBook(rentalId));
    }

     
    
}

package com.crio.RentRead.Services;

import org.springframework.stereotype.Service;

import com.crio.RentRead.Entity.Rental;

public interface RentalService {

    public Rental rentBook(Long userId,Long bookId);

    public Rental returnBook(Long rentalId);
    
    
}

package com.crio.RentRead.Services;

import java.time.LocalDate;
import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.RentRead.Entity.Book;
import com.crio.RentRead.Entity.Rental;
import com.crio.RentRead.Entity.User;
import com.crio.RentRead.Repository.BookRepository;
import com.crio.RentRead.Repository.RentalRepository;
import com.crio.RentRead.Repository.UserRepository;

@Service
public class RentalServiceImpl implements RentalService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    RentalRepository rentalRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public Rental rentBook(Long userId, Long bookId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'rentBook'");

         User user =  userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        if (rentalRepository.findByUserAndReturnDateIsNull(user).size() >= 2) {
            throw new RuntimeException("User has already rented 2 books");
        }

        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        if (!book.isAvailabilityStatus()) {
            throw new RuntimeException("Book is not available");
        }

        book.setAvailabilityStatus(false);
        bookRepository.save(book);

        Rental rental = new Rental();
        rental.setUser(user);
        rental.setBook(book);
        rental.setRentalDate(LocalDateTime.now());
        return rentalRepository.save(rental);
    }

    @Override
    public Rental returnBook(Long rentalId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'returnBook'");

        Rental rental = rentalRepository.findById(rentalId).orElseThrow(() -> new RuntimeException("Rental not found"));
        rental.setReturnDate(LocalDateTime.now());

        Book book = rental.getBook();
        book.setAvailabilityStatus(true);
        bookRepository.save(book);

        return rentalRepository.save(rental);
    }

    
}

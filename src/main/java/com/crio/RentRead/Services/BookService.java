package com.crio.RentRead.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.crio.RentRead.Entity.Book;


public interface BookService {

    public  List<Book> getAllBooks();

    public Optional<Book> getBookById(Long bookId);

    public void deleteBookById(Long bookId);

    public Book updateBook(Long id ,Book book);

    public Book saveBook(Book book);


    

    
}
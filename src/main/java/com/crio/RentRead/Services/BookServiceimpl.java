package com.crio.RentRead.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.RentRead.Entity.Book;
import com.crio.RentRead.Repository.BookRepository;

@Service
public class BookServiceimpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getAllBooks'");

        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long bookId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getBookById'");
        return bookRepository.findById(bookId);
    }

    @Override
    public void deleteBookById(Long bookId) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'deleteBookById'");
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            bookRepository.deleteById(bookId);
        } else {
            throw new RuntimeException("Book not found");
        }

    }

    @Override
    public Book updateBook(Long id ,Book book) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'updateBook'");
        Optional<Book> optionalBook = bookRepository.findById(id);
    if (optionalBook.isPresent()) {
        // bookRepository.deleteById(book.getBookId());
        Book b= optionalBook.get();
        b.setAuthor(book.getAuthor());
        b.setAvailabilityStatus(book.isAvailabilityStatus());
        b.setGenre(book.getGenre());
        b.setTitle(book.getTitle());
        bookRepository.deleteById(id);
        return bookRepository.save(b);

    } else {
        throw new RuntimeException("Book not found");
    }
    }

    @Override
    public Book saveBook(Book book) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'saveBook'");
        return bookRepository.save(book);

    }

    

    
}

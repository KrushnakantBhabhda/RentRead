package com.crio.RentRead.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
// import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crio.RentRead.Entity.Book;
import com.crio.RentRead.Services.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

     @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @PostMapping
     @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Book> createBook(@RequestBody @Valid Book book) {
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @PutMapping("/{id}")
     @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody @Valid Book bookDetails) {
     
        return ResponseEntity.ok(bookService.updateBook(id,bookDetails));
    }

    @DeleteMapping("/{id}")
     @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }


    
}

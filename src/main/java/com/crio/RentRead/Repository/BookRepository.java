package com.crio.RentRead.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crio.RentRead.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{

    
} 

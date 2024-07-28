package com.crio.RentRead.Entity;

import java.util.HashSet;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
// import net.bytebuddy.dynamic.NexusAccessor.Dispatcher.Available;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long bookId;

    String title;

    String author;

    String genre;

    boolean availabilityStatus;

      @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private HashSet<Rental> rentals = new HashSet<>();





    
}

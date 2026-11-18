package in.ashokit.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "book_dtls")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String bookName;
    private String bookIsbn;
    private Integer availableCopies;
}

package za.ac.readiculous.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;  // must be an object type for JPA

    private String title;
    private String author;
    private String genre;
    private String description;
    private LocalDate publishedDate;
    private int totalPages;
    private String isbn;

    public Book() {}

    public Book(Long bookId, String title, String author, String genre,
                String description, LocalDate publishedDate, int totalPages, String isbn) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.description = description;
        this.publishedDate = publishedDate;
        this.totalPages = totalPages;
        this.isbn = isbn;
    }

    // getters & setters...
}

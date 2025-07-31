package za.ac.readiculous.domain;

import java.time.LocalDate;

public class Book {

    private long bookId;
    private String title;
    private String author;
    private String genre;
    private String description;
    private LocalDate publishedDate;
    private int totalPages;
    private String isbn;

    // Constructor
    public Book(long bookId, String title, String author, String genre,
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

    // Default constructor
    public Book() {}

    // Getters and Setters
    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // toString method
    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", publishedDate=" + publishedDate +
                ", totalPages=" + totalPages +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}

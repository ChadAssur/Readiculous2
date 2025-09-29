package za.ac.readiculous.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String title;
    private String author;
    private String description;
    private String genre;
    private int yearPublished;

    // Default constructor required by JPA
    protected Book() {}

    // Builder constructor
    private Book(Builder builder) {
        this.bookId = builder.bookId;
        this.title = builder.title;
        this.author = builder.author;
        this.description = builder.description;
        this.genre = builder.genre;
        this.yearPublished = builder.yearPublished;
    }

    // Getters
    public Long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return yearPublished == book.yearPublished &&
                Objects.equals(bookId, book.bookId) &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(description, book.description) &&
                Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, author, description, genre, yearPublished);
    }

    // toString
    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", yearPublished=" + yearPublished +
                '}';
    }

    // Builder class
    public static class Builder {
        private Long bookId;
        private String title;
        private String author;
        private String description;
        private String genre;
        private int yearPublished;

        public Builder setBookId(Long bookId) {
            this.bookId = bookId;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder setYearPublished(int yearPublished) {
            this.yearPublished = yearPublished;
            return this;
        }

        public Builder copy(Book book) {
            this.bookId = book.bookId;
            this.title = book.title;
            this.author = book.author;
            this.description = book.description;
            this.genre = book.genre;
            this.yearPublished = book.yearPublished;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}

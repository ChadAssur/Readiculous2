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
    private String message;

    // Default constructor
    public Book() {}

    // Builder constructor
    public Book(Builder builder) {
        this.bookId = builder.bookId;
        this.title = builder.title;
        this.message = builder.message;
    }

    // Getters
    public Long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(bookId, book.bookId) &&
                Objects.equals(title, book.title) &&
                Objects.equals(message, book.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, message);
    }

    // toString
    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    // Builder class
    public static class Builder {
        private Long bookId;
        private String title;
        private String message;

        public Builder setBookId(Long bookId) {
            this.bookId = bookId;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        // Copy method
        public Builder copy(Book book) {
            this.bookId = book.bookId;
            this.title = book.title;
            this.message = book.message;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}

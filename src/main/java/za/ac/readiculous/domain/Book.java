package za.ac.readiculous.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;  // Changed to Integer

    private String title;
    private String author;

    @Column(length = 2000)
    private String description;

    private String genre;
    private int yearPublished;

    @Lob
    @Column(columnDefinition = "LONGBLOB", nullable = true)
    private byte[] image; // Optional book cover image

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_id", nullable = true)
    private User user; // Owner of the book (optional)

    // === Default constructor required by JPA ===
    public Book() {}

    // === Getters and Setters ===
    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getYearPublished() { return yearPublished; }
    public void setYearPublished(int yearPublished) { this.yearPublished = yearPublished; }

    public byte[] getImage() { return image; }
    public void setImage(byte[] image) { this.image = image; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    // === Optional Builder for easier object creation ===
    public static class Builder {
        private Integer bookId;  // Changed to Integer
        private String title;
        private String author;
        private String description;
        private String genre;
        private int yearPublished;
        private byte[] image;
        private User user;

        public Builder setBookId(Integer bookId) {
            this.bookId = bookId;
            return this;
        }

        public Builder setTitle(String title) { this.title = title; return this; }
        public Builder setAuthor(String author) { this.author = author; return this; }
        public Builder setDescription(String description) { this.description = description; return this; }
        public Builder setGenre(String genre) { this.genre = genre; return this; }
        public Builder setYearPublished(int yearPublished) { this.yearPublished = yearPublished; return this; }
        public Builder setImage(byte[] image) { this.image = image; return this; }
        public Builder setUser(User user) { this.user = user; return this; }

        public Book build() {
            Book book = new Book();
            book.bookId = this.bookId;
            book.title = this.title;
            book.author = this.author;
            book.description = this.description;
            book.genre = this.genre;
            book.yearPublished = this.yearPublished;
            book.image = this.image;
            book.user = this.user;
            return book;
        }
    }
}

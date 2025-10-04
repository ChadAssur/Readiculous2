package za.ac.readiculous.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String title;
    private String author;

    @Column(length = 2000)
    private String description;

    private String genre;
    private int yearPublished;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image; // book cover image

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // Link to User

    protected Book() {}

    private Book(Builder builder) {
        this.bookId = builder.bookId;
        this.title = builder.title;
        this.author = builder.author;
        this.description = builder.description;
        this.genre = builder.genre;
        this.yearPublished = builder.yearPublished;
        this.image = builder.image;
        this.user = builder.user;
    }

    // === Getters ===
    public Long getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getDescription() { return description; }
    public String getGenre() { return genre; }
    public int getYearPublished() { return yearPublished; }
    public byte[] getImage() { return image; }
    public User getUser() { return user; }

    // === Builder ===
    public static class Builder {
        private Long bookId;
        private String title;
        private String author;
        private String description;
        private String genre;
        private int yearPublished;
        private byte[] image;
        private User user;

        public Builder setBookId(Long bookId) { this.bookId = bookId; return this; }
        public Builder setTitle(String title) { this.title = title; return this; }
        public Builder setAuthor(String author) { this.author = author; return this; }
        public Builder setDescription(String description) { this.description = description; return this; }
        public Builder setGenre(String genre) { this.genre = genre; return this; }
        public Builder setYearPublished(int yearPublished) { this.yearPublished = yearPublished; return this; }
        public Builder setImage(byte[] image) { this.image = image; return this; }
        public Builder setUser(User user) { this.user = user; return this; }

        public Book build() { return new Book(this); }
    }
}

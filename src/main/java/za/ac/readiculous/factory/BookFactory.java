package za.ac.readiculous.factory;

import za.ac.readiculous.domain.Book;

import java.time.LocalDate;

public class BookFactory {

    public static Book createBook(
            long bookId,
            String title,
            String author,
            String genre,
            String description,
            LocalDate publishedDate,
            int totalPages,
            String isbn
    ) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title is required.");
        }
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author is required.");
        }
        if (genre == null || genre.isEmpty()) {
            genre = "Unknown";
        }
        if (description == null) {
            description = "";
        }
        if (publishedDate == null) {
            publishedDate = LocalDate.now(); // default to today
        }
        if (totalPages <= 0) {
            totalPages = 100; // default value
        }
        if (isbn == null || isbn.isEmpty()) {
            isbn = "000-0000000000"; // default placeholder ISBN
        }

        return new Book(bookId, title, author, genre, description, publishedDate, totalPages, isbn);
    }
}

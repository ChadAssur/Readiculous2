package za.ac.readiculous.factory;

import za.ac.readiculous.domain.Book;

public class BookFactory {

    public static Book createBook(String title, String author, String description, String genre, int yearPublished) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title is required.");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author is required.");
        }
        if (description == null) {
            description = ""; // default empty
        }
        if (genre == null) {
            genre = "Unknown"; // default genre
        }

        return new Book.Builder()
                .setTitle(title)
                .setAuthor(author)
                .setDescription(description)
                .setGenre(genre)
                .setYearPublished(yearPublished)
                .build();
    }
}

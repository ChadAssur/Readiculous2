package za.ac.readiculous.factory;

import za.ac.readiculous.domain.Book;

public class BookFactory {

    public static Book createBook(long bookId, String title, String message) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title is required.");
        }
        if (message == null) {
            message = ""; // default to empty message
        }

        return new Book.Builder()
                .setBookId(bookId)
                .setTitle(title)
                .setMessage(message)
                .build();
    }
}

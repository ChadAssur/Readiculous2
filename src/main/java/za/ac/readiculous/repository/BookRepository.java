package za.ac.readiculous.repository;

import za.ac.readiculous.domain.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository {

    private static final List<Book> books = new ArrayList<>();

    // Create / Add a book
    public static Book save(Book book) {
        books.add(book);
        return book;
    }

    // Read / Get a book by ID
    public static Optional<Book> findById(long bookId) {
        return books.stream()
                .filter(book -> book.getBookId() == bookId)
                .findFirst();
    }

    // Read / Get all books
    public static List<Book> findAll() {
        return new ArrayList<>(books);
    }

    // Update a book
    public static Book update(Book updatedBook) {
        findById(updatedBook.getBookId()).ifPresent(existingBook -> {
            books.remove(existingBook);
            books.add(updatedBook);
        });
        return updatedBook;
    }

    // Delete a book by ID
    public static boolean deleteById(long bookId) {
        return books.removeIf(book -> book.getBookId() == bookId);
    }

    // Delete all books
    public static void clear() {
        books.clear();
    }
}

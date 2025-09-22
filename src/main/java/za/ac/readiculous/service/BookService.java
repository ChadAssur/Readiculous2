package za.ac.readiculous.service;

import org.springframework.stereotype.Service;
import za.ac.readiculous.domain.Book;
import za.ac.readiculous.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> read(Long bookId) {
        return bookRepository.findById(bookId);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book update(Book book) {
        // Check if the book exists
        Optional<Book> existingBook = bookRepository.findById(book.getBookId());
        if (existingBook.isPresent()) {
            // Use Builder to create an updated instance
            Book updatedBook = new Book.Builder()
                    .copy(existingBook.get())
                    .setTitle(book.getTitle())
                    .setMessage(book.getMessage())
                    .build();
            return bookRepository.save(updatedBook);
        } else {
            throw new IllegalArgumentException("Book with ID " + book.getBookId() + " does not exist.");
        }
    }

    public boolean delete(Long bookId) {
        if (bookRepository.existsById(bookId)) {
            bookRepository.deleteById(bookId);
            return true;
        }
        return false;
    }
}

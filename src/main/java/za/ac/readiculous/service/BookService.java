package za.ac.readiculous.service;

import org.springframework.stereotype.Service;
import za.ac.readiculous.domain.Book;
import za.ac.readiculous.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    // Constructor injection
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
        return bookRepository.save(book); // same method for create & update
    }

    public boolean delete(Long bookId) {
        if (bookRepository.existsById(bookId)) {
            bookRepository.deleteById(bookId);
            return true;
        }
        return false;
    }
}

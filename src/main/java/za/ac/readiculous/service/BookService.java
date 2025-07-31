package za.ac.readiculous.service;

import za.ac.readiculous.domain.Book;
import za.ac.readiculous.repository.BookRepository;

import java.util.List;
import java.util.Optional;

public class BookService implements IBookService {

    @Override
    public Book create(Book book) {
        return BookRepository.save(book);
    }

    @Override
    public Optional<Book> read(long bookId) {
        return BookRepository.findById(bookId);
    }

    @Override
    public List<Book> getAll() {
        return BookRepository.findAll();
    }

    @Override
    public Book update(Book book) {
        return BookRepository.update(book);
    }

    @Override
    public boolean delete(long bookId) {
        return BookRepository.deleteById(bookId);
    }
}

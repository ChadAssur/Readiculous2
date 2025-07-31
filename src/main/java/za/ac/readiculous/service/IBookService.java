package za.ac.readiculous.service;

import za.ac.readiculous.domain.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    Book create(Book book);
    Optional<Book> read(long bookId);
    List<Book> getAll();
    Book update(Book book);
    boolean delete(long bookId);
}

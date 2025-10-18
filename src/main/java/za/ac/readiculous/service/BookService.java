package za.ac.readiculous.service;

/* BookService class.java
Author: [Your Name]
Date: [Today’s Date]
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.readiculous.domain.Book;
import za.ac.readiculous.domain.User;
import za.ac.readiculous.repository.BookRepository;

import java.util.List;

@Service
public class BookService implements IBookService {

    private final BookRepository repository;

    @Autowired
    BookService(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public Book create(Book book) {
        return this.repository.save(book);
    }

    @Override
    public Book read(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Book update(Book book) {
        // Save will act as update if the ID exists
        return this.repository.save(book);
    }

    @Override
    public boolean delete(Long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Book> getAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Book> findByTitle(String title) {
        return this.repository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return this.repository.findByAuthorContainingIgnoreCase(author);
    }

    @Override
    public List<Book> findByGenre(String genre) {
        return this.repository.findByGenreIgnoreCase(genre);
    }

    @Override
    public List<Book> findByYearPublished(int yearPublished) {
        return this.repository.findByYearPublished(yearPublished);
    }

    // 🔹 New: Find all books by User
    public List<Book> findByUser(User user) {
        return this.repository.findByUser(user);
    }

    // 🔹 New: Find all books by userId
    public List<Book> findByUserId(Integer userId) {
        return this.repository.findByUser_UserId(userId);
    }
}

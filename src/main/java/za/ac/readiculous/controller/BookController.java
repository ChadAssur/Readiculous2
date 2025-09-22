package za.ac.readiculous.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.readiculous.domain.Book;
import za.ac.readiculous.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/Book")
@CrossOrigin(origins = "http://localhost:5173")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Create a new Book
    @PostMapping("/create")
    public Book create(@RequestBody Book book) {
        return bookService.create(book);
    }

    // Read a Book by ID
    @GetMapping("/read/{id}")
    public Book read(@PathVariable Long id) {
        return bookService.read(id).orElse(null);
    }

    // Update a Book
    @PutMapping("/update")
    public Book update(@RequestBody Book book) {
        return bookService.update(book);
    }

    // Delete a Book by ID
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return bookService.delete(id);
    }

    // Get all Books
    @GetMapping("/getAll")
    public List<Book> getAll() {
        return bookService.getAll();
    }
}

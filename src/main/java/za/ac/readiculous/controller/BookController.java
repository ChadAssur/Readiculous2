package za.ac.readiculous.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.readiculous.domain.Book;
import za.ac.readiculous.service.IBookService;

import java.util.List;

@RestController
@RequestMapping("/api/books")  // lowercase and plural is conventional
@CrossOrigin(origins = "http://localhost:5173")
public class BookController {

    private final IBookService bookService;

    @Autowired
    public BookController(IBookService bookService) {
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
        return bookService.read(id);
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

    // --- Search Endpoints ---

    @GetMapping("/search/title")
    public List<Book> findByTitle(@RequestParam String title) {
        return bookService.findByTitle(title);
    }

    @GetMapping("/search/author")
    public List<Book> findByAuthor(@RequestParam String author) {
        return bookService.findByAuthor(author);
    }

    @GetMapping("/search/genre")
    public List<Book> findByGenre(@RequestParam String genre) {
        return bookService.findByGenre(genre);
    }

    @GetMapping("/search/year")
    public List<Book> findByYear(@RequestParam int year) {
        return bookService.findByYearPublished(year);
    }
}

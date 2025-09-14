package za.ac.readiculous.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.readiculous.domain.Book;
import za.ac.readiculous.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;
    private BookService service;

    @Autowired
    public BookController(BookService bookService, BookService service) {
        this.bookService = bookService;
        this.service = service;
    }

    @PostMapping("/create")
    public Book create(@RequestBody Book book) {
        return service.create(book);
    }

    @GetMapping("/read/{id}")
    public Book read(@PathVariable long id) {
        return service.read(id).orElse(null);
    }

    @PutMapping("/update")
    public Book update(@RequestBody Book book) {
        return service.update(book);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable long id) {
        return service.delete(id);
    }

    @GetMapping("/getAll")
    public List<Book> getAll() {
        return service.getAll();
    }
}
package za.ac.readiculous.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.readiculous.domain.BookClub;
import za.ac.readiculous.service.BookClubService;


import java.util.List;
@RestController
@RequestMapping("/api/BookClub")
@CrossOrigin(origins = "http://localhost:5173")
public class BookClubController {

    private final BookClubService bookclubService;
    private BookClubService service;

    @Autowired
    public BookClubController(BookClubService bookclubService, BookClubService service) {
        this.bookclubService = bookclubService;
        this.service = service;
    }

    @PostMapping("/create")
    public BookClub create(@RequestBody BookClub bookClub) {
        return service.create(bookClub);
    }


    @GetMapping("/read/{clubId}")
    public BookClub read(@PathVariable long clubId) {
        return service.read(clubId);
    }

    @PutMapping("/update")
    public BookClub update(@RequestBody BookClub bookClub) {
        return service.update(bookClub);
    }

    @DeleteMapping("/delete/{clubId}")
    public boolean delete(@PathVariable long clubId) {
        return service.delete(clubId);
    }

    @GetMapping("/getAll")
    public List<BookClub> getAll() {
        return service.getAll();
    }

}

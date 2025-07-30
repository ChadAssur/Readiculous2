package za.ac.readiculous.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.readiculous.domain.BookClub;
import za.ac.readiculous.service.IBookClubService;

import java.util.List;

@RestController
@RequestMapping("/api/bookclubs")
public class BookClubController {

    private final IBookClubService bookClubService;

    @Autowired
    public BookClubController(IBookClubService bookClubService) {
        this.bookClubService = bookClubService;
    }

    @PostMapping("/create")
    public BookClub createBookClub(@RequestBody BookClub club) {
        return bookClubService.create(club);
    }

    @GetMapping("/read/{id}")
    public BookClub readBookClub(@PathVariable long id) {
        return bookClubService.read(id);
    }

    @PutMapping("/update")
    public BookClub updateBookClub(@RequestBody BookClub club) {
        return bookClubService.update(club);
    }

    @DeleteMapping("/delete/{id}")
    public boolean deleteBookClub(@PathVariable long id) {
        return bookClubService.delete(id);
    }

    @GetMapping("/all")
    public List<BookClub> getAllBookClubs() {
        return bookClubService.getAll();
    }
}

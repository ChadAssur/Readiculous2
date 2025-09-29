package za.ac.readiculous.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.readiculous.domain.BookClub;
import za.ac.readiculous.domain.User;
import za.ac.readiculous.factory.BookClubFactory;
import za.ac.readiculous.service.BookClubService;
import za.ac.readiculous.service.UserService;
import za.ac.readiculous.util.BookClubDTO;


import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("/book-club")
@CrossOrigin(origins = "http://localhost:5173")
public class BookClubController {

    private final BookClubService bookClubService;
    private final UserService userService;

    @Autowired
    public BookClubController(BookClubService bookClubService, UserService userService) {
        this.bookClubService = bookClubService;
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<BookClubDTO> createClub(@RequestBody BookClubDTO dto) {
        User user = userService.read(dto.getOwnerId());
        if (user == null) return ResponseEntity.badRequest().build();

        BookClub club = BookClubFactory.createBookClub(dto.getClubName(), dto.getClubDescription(), LocalDateTime.now(), user);
        BookClub created = bookClubService.create(club);

        return ResponseEntity.ok(new BookClubDTO(created.getClubId(), created.getClubName(), created.getClubDescription(), created.getOwner().getUserId()));
    }

    @GetMapping("/all")
    public List<BookClubDTO> getAllClubs() {
        return bookClubService.getAll().stream()
                .map(c -> new BookClubDTO(c.getClubId(), c.getClubName(), c.getClubDescription(), c.getOwner().getUserId()))
                .toList();
    }
}

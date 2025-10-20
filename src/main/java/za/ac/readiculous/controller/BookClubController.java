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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/book-club")
@CrossOrigin(origins = "http://localhost:5173")
public class BookClubController {

    private final BookClubService bookClubService;
    private final UserService userService;

    @Autowired
    public BookClubController(BookClubService bookClubService, UserService userService) {
        this.bookClubService = bookClubService;
        this.userService = userService;
    }

    /**
     * Create a new BookClub
     */
    @PostMapping("/create")
    public ResponseEntity<?> createClub(@RequestBody BookClubDTO dto) {

        // Validate ownerId
        if (dto.getOwnerId() == null) {
            return ResponseEntity.badRequest().body("Owner ID is required");
        }

        // Get owner user
        User owner = userService.read(dto.getOwnerId());
        if (owner == null) {
            return ResponseEntity.badRequest()
                    .body("User not found for ID: " + dto.getOwnerId());
        }

        // Create BookClub using factory
        BookClub club = BookClubFactory.createBookClub(
                dto.getClubName(),
                dto.getClubDescription(),
                LocalDateTime.now(),
                owner
        );

        if (club == null) {
            return ResponseEntity.badRequest().body("Invalid book club data");
        }

        // Save club
        BookClub created = bookClubService.create(club);

        // Prepare response DTO
        BookClubDTO responseDto = new BookClubDTO(
                created.getClubId(),
                created.getClubName(),
                created.getClubDescription(),
                created.getOwner() != null ? created.getOwner().getUserId() : null
        );

        return ResponseEntity.ok(responseDto);
    }

    /**
     * Get all BookClubs
     */
    @GetMapping("/all")
    public ResponseEntity<List<BookClubDTO>> getAllClubs() {
        List<BookClubDTO> clubs = bookClubService.getAll().stream()
                .map(c -> new BookClubDTO(
                        c.getClubId(),
                        c.getClubName(),
                        c.getClubDescription(),
                        c.getOwner() != null ? c.getOwner().getUserId() : null
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(clubs);
    }
}
//
//@RestController
//@RequestMapping("/api/book-club")
//@CrossOrigin(origins = "http://localhost:5173")
//public class BookClubController {
//
//
//    private final BookClubService bookClubService;
//    private final UserService userService;
//
//
//    @Autowired
//    public BookClubController(BookClubService bookClubService, UserService userService) {
//        this.bookClubService = bookClubService;
//        this.userService = userService;
//    }
//
//
//
//
//
//
//    @PostMapping("/create")
//    public ResponseEntity<BookClubDTO> create(@RequestBody BookClubDTO dto) {
//        System.out.println("Received DTO: " + dto);
//
//
//        User user = userService.read(dto.getOwnerId());
//        if (user == null) {
//            System.out.println("User not found with ID: " + dto.getOwnerId());
//            return ResponseEntity.badRequest().build();
//        }
//
//
//        BookClub club = BookClubFactory.createBookClub(
//                dto.getClubName(),
//                dto.getClubDescription(),
//                LocalDateTime.now(),
//                user);
//
//
//
//
//        BookClub created = bookClubService.create(club);
//        System.out.println("Saved club: " + created);
//
//
//        return ResponseEntity.ok(new BookClubDTO(created.getClubId(), created.getClubName(), created.getClubDescription(), created.getOwner().getUserId()));
//    }
//
//
//    @GetMapping("/all")
//    public List<BookClubDTO> getAllClubs() {
//        return bookClubService.getAll().stream()
//                .map(c -> new BookClubDTO(c.getClubId(), c.getClubName(), c.getClubDescription(), c.getOwner().getUserId()))
//                .toList();
//    }
//}

package za.ac.readiculous.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Bookclub")
public class BookClub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long clubId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="owner_id")
    private User owner;

    private String clubName;
    private String clubDescription;
    private LocalDateTime createdAt;


    protected BookClub() {}

    private BookClub(Builder builder) {
        this.clubId = builder.clubId;
        this.owner = builder.owner;
        this.clubName = builder.clubName;
        this.clubDescription = builder.clubDescription;
        this.createdAt = builder.createdAt;
    }

    public Long getClubId() { return clubId; }
    public User getOwner() { return owner; }
    public String getClubName() { return clubName; }
    public String getClubDescription() { return clubDescription; }
    public LocalDateTime getCreatedAt() { return createdAt; }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof BookClub that)) return false;
//        return Objects.equals(clubId, that.clubId) &&
//                Objects.equals(userId, that.userId) &&
//                Objects.equals(clubName, that.clubName) &&
//                Objects.equals(clubDescription, that.clubDescription) &&
//                Objects.equals(createdAt, that.createdAt);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(clubId, userId, clubName, clubDescription, createdAt);
//    }

    @Override
    public String toString() {
        return "BookClub{" +
                "clubId=" + clubId +
                ", ownerId=" + owner +
                ", clubName='" + clubName + '\'' +
                ", clubDescription='" + clubDescription + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public static class Builder {
        private long clubId;
        private User owner;
        private String clubName;
        private String clubDescription;
        private LocalDateTime createdAt;

//        public Builder setClubId(Long clubId) {
//            this.clubId = clubId;
//            return this;
//        }

        public Builder setUser(User owner) {
            this.owner = owner;
            return this;
        }

        public Builder setClubName(String clubName) {
            this.clubName = clubName;
            return this;
        }

        public Builder setClubDescription(String clubDescription) {
            this.clubDescription = clubDescription;
            return this;
        }

        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }


        public Builder copy(BookClub bookClub) {
            this.clubId = bookClub.clubId;
            this.owner = bookClub.owner;
            this.clubName = bookClub.clubName;
            this.clubDescription = bookClub.clubDescription;
            this.createdAt = bookClub.createdAt;
            return this;
        }

        public BookClub build() {
            return new BookClub(this);
        }
    }
}


//package za.ac.readiculous.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import za.ac.readiculous.domain.BookClub;
//import za.ac.readiculous.domain.User;
//import za.ac.readiculous.factory.BookClubFactory;
//import za.ac.readiculous.service.BookClubService;
//import za.ac.readiculous.service.UserService;
//import za.ac.readiculous.util.BookClubDTO;
//
//
//import java.time.LocalDateTime;
//import java.util.List;
//@RestController
//@RequestMapping("/book-club")
//@CrossOrigin(origins = "http://localhost:5173")
//public class BookClubController {
//
//    private final BookClubService bookClubService;
//    private final UserService userService;
//
//    public BookClubController(BookClubService bookClubService, UserService userService) {
//        this.bookClubService = bookClubService;
//        this.userService = userService;
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<BookClubDTO> createClub(@RequestBody BookClubDTO dto) {
//        User user = userService.read(dto.getUserId());
//        if (user == null) return ResponseEntity.badRequest().build();
//
//        BookClub club = BookClubFactory.createBookClub(dto.getClubName(), dto.getClubDescription(), LocalDateTime.now(), user);
//        BookClub created = bookClubService.create(club);
//
//        return ResponseEntity.ok(new BookClubDTO(created.getClubId(), created.getClubName(), created.getClubDescription(), created.getUser().getUserId()));
//    }
//
//    @GetMapping("/all")
//    public List<BookClubDTO> getAllClubs() {
//        return bookClubService.getAll().stream()
//                .map(c -> new BookClubDTO(c.getClubId(), c.getClubName(), c.getClubDescription(), c.getUser().getUserId()))
//                .toList();
//    }
//}

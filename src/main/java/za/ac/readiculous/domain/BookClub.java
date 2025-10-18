package za.ac.readiculous.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BookClub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clubId;

    private String clubName;
    private String clubDescription;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    protected BookClub() {}  // JPA

    private BookClub(Builder builder) {
        this.clubId = builder.clubId;
        this.clubName = builder.clubName;
        this.clubDescription = builder.clubDescription;
        this.createdAt = builder.createdAt;
        this.owner = builder.owner;
    }

    public Integer getClubId() { return clubId; }
    public String getClubName() { return clubName; }
    public String getClubDescription() { return clubDescription; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public User getOwner() { return owner; }

    public static class Builder {
        private Integer clubId;
        private String clubName;
        private String clubDescription;
        private LocalDateTime createdAt;
        private User owner;

        public Builder setClubId(Integer clubId) { this.clubId = clubId; return this; }
        public Builder setClubName(String clubName) { this.clubName = clubName; return this; }
        public Builder setClubDescription(String clubDescription) { this.clubDescription = clubDescription; return this; }
        public Builder setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; return this; }
        public Builder setUser(User owner) { this.owner = owner; return this; }

        public BookClub build() { return new BookClub(this); }
    }
}

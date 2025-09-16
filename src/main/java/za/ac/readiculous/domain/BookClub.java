package za.ac.readiculous.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "bookclub")
public class BookClub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long clubId;
    protected Long organizerId;
    protected String clubName;
    protected String clubDescription;
    protected LocalDateTime createdAt;


    protected BookClub() {}

    private BookClub(Builder builder) {
        this.clubId = builder.clubId;
        this.organizerId = builder.organizerId;
        this.clubName = builder.clubName;
        this.clubDescription = builder.clubDescription;
        this.createdAt = builder.createdAt;
    }

    public Long getClubId() { return clubId; }
    public Long getOrganizerId() { return organizerId; }
    public String getClubName() { return clubName; }
    public String getClubDescription() { return clubDescription; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookClub that)) return false;
        return Objects.equals(clubId, that.clubId) &&
                Objects.equals(organizerId, that.organizerId) &&
                Objects.equals(clubName, that.clubName) &&
                Objects.equals(clubDescription, that.clubDescription) &&
                Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubId, organizerId, clubName, clubDescription, createdAt);
    }

    @Override
    public String toString() {
        return "BookClub{" +
                "clubId=" + clubId +
                ", organizerId=" + organizerId +
                ", clubName='" + clubName + '\'' +
                ", clubDescription='" + clubDescription + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    public static class Builder {
        private Long clubId;
        private Long organizerId;
        private String clubName;
        private String clubDescription;
        private LocalDateTime createdAt;

        public Builder setClubId(Long clubId) {
            this.clubId = clubId;
            return this;
        }

        public Builder setOrganizerId(Long organizerId) {
            this.organizerId = organizerId;
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
            this.organizerId = bookClub.organizerId;
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

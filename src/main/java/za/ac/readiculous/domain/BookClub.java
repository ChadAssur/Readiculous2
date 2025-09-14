package za.ac.readiculous.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "bookclub")
public class BookClub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clubId;

    private Long organizerId;
    private String clubName;
    private String clubDescription;
    private String clubGenre;
    private LocalDateTime createdAt;
    private String memberList;


    @Transient
    private EventManagement scheduleMeeting;

    protected BookClub() {}

    private BookClub(Builder builder) {
        this.clubId = builder.clubId;
        this.organizerId = builder.organizerId;
        this.clubName = builder.clubName;
        this.clubDescription = builder.clubDescription;
        this.clubGenre = builder.clubGenre;
        this.createdAt = builder.createdAt;
        this.memberList = builder.memberList;
        this.scheduleMeeting = builder.scheduleMeeting;
    }

    public Long getClubId() { return clubId; }
    public Long getOrganizerId() { return organizerId; }
    public String getClubName() { return clubName; }
    public String getClubDescription() { return clubDescription; }
    public String getClubGenre() { return clubGenre; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public String getMemberList() { return memberList; }
    public EventManagement getScheduleMeeting() { return scheduleMeeting; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookClub that)) return false;
        return Objects.equals(clubId, that.clubId) &&
                Objects.equals(organizerId, that.organizerId) &&
                Objects.equals(clubName, that.clubName) &&
                Objects.equals(clubDescription, that.clubDescription) &&
                Objects.equals(clubGenre, that.clubGenre) &&
                Objects.equals(createdAt, that.createdAt) &&
                Objects.equals(memberList, that.memberList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clubId, organizerId, clubName, clubDescription, clubGenre, createdAt, memberList);
    }

    @Override
    public String toString() {
        return "BookClub{" +
                "clubId=" + clubId +
                ", organizerId=" + organizerId +
                ", clubName='" + clubName + '\'' +
                ", clubDescription='" + clubDescription + '\'' +
                ", clubGenre='" + clubGenre + '\'' +
                ", createdAt=" + createdAt +
                ", memberList='" + memberList + '\'' +
                ", scheduleMeeting=" + scheduleMeeting +
                '}';
    }

    public static class Builder {
        private Long clubId;
        private Long organizerId;
        private String clubName;
        private String clubDescription;
        private String clubGenre;
        private LocalDateTime createdAt;
        private String memberList;
        private EventManagement scheduleMeeting;

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

        public Builder setClubGenre(String clubGenre) {
            this.clubGenre = clubGenre;
            return this;
        }

        public Builder setCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder setMemberList(String memberList) {
            this.memberList = memberList;
            return this;
        }

        public Builder setScheduleMeeting(EventManagement scheduleMeeting) {
            this.scheduleMeeting = scheduleMeeting;
            return this;
        }

        public Builder copy(BookClub bookClub) {
            this.clubId = bookClub.clubId;
            this.organizerId = bookClub.organizerId;
            this.clubName = bookClub.clubName;
            this.clubDescription = bookClub.clubDescription;
            this.clubGenre = bookClub.clubGenre;
            this.createdAt = bookClub.createdAt;
            this.memberList = bookClub.memberList;
            this.scheduleMeeting = bookClub.scheduleMeeting;
            return this;
        }

        public BookClub build() {
            return new BookClub(this);
        }
    }
}

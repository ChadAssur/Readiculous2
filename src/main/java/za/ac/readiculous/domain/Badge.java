package za.ac.readiculous.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "badges") // optional, defaults to class name
public class Badge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long badgeId;

    private String name;
    private String description;
    private LocalDate awardedDate;
    private long userId; // Assuming badges are awarded to users

    // No-arg constructor required by JPA
    public Badge() {}

    // All-args constructor
    public Badge(long badgeId, String name, String description,
                 LocalDate awardedDate, long userId) {
        this.badgeId = badgeId;
        this.name = name;
        this.description = description;
        this.awardedDate = awardedDate;
        this.userId = userId;
    }

    // Getters and setters
    public long getBadgeId() { return badgeId; }
    public void setBadgeId(long badgeId) { this.badgeId = badgeId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getAwardedDate() { return awardedDate; }
    public void setAwardedDate(LocalDate awardedDate) { this.awardedDate = awardedDate; }

    public long getUserId() { return userId; }
    public void setUserId(long userId) { this.userId = userId; }

    // Builder
    public static class Builder {
        private long badgeId;
        private String name;
        private String description;
        private LocalDate awardedDate;
        private long userId;

        public Builder setBadgeId(long badgeId) { this.badgeId = badgeId; return this; }
        public Builder setName(String name) { this.name = name; return this; }
        public Builder setDescription(String description) { this.description = description; return this; }
        public Builder setAwardedDate(LocalDate awardedDate) { this.awardedDate = awardedDate; return this; }
        public Builder setUserId(long userId) { this.userId = userId; return this; }

        public Badge build() {
            return new Badge(badgeId, name, description, awardedDate, userId);
        }
    }
}



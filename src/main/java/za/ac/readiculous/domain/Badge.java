package za.ac.readiculous.domain;

import java.time.LocalDate;

public class Badge {

    private long badgeId;
    private String name;
    private String description;
    private LocalDate awardedDate;
    private long userId; // Assuming badges are awarded to users

    // Constructor
    public Badge(long badgeId, String name, String description,
                 LocalDate awardedDate, long userId) {
        this.badgeId = badgeId;
        this.name = name;
        this.description = description;
        this.awardedDate = awardedDate;
        this.userId = userId;
    }

    // Getters
    public long getBadgeId() { return badgeId; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public LocalDate getAwardedDate() { return awardedDate; }
    public long getUserId() { return userId; }

    // Builder
    public static class Builder {
        private long badgeId;
        private String name;
        private String description;
        private LocalDate awardedDate;
        private long userId;

        public Builder setBadgeId(long badgeId) {
            this.badgeId = badgeId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setAwardedDate(LocalDate awardedDate) {
            this.awardedDate = awardedDate;
            return this;
        }

        public Builder setUserId(long userId) {
            this.userId = userId;
            return this;
        }

        public Badge build() {
            return new Badge(badgeId, name, description, awardedDate, userId);
        }
    }
}



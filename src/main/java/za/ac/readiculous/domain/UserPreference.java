package za.ac.readiculous.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_preferences")
public class UserPreference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long preferenceId;

    private Integer userId; // link to the User entity

    private String genre;
    private String frequency;
    private String format;

    // Default constructor for JPA
    protected UserPreference() {}

    // Private constructor for Builder
    private UserPreference(Builder builder) {
        this.preferenceId = builder.preferenceId;
        this.userId = builder.userId;
        this.genre = builder.genre;
        this.frequency = builder.frequency;
        this.format = builder.format;
    }

    // Getters
    public Long getPreferenceId() {
        return preferenceId;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getGenre() {
        return genre;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserPreference)) return false;
        UserPreference that = (UserPreference) o;
        return Objects.equals(preferenceId, that.preferenceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(preferenceId);
    }

    // Builder class
    public static class Builder {
        private Long preferenceId;
        private Integer userId;
        private String genre;
        private String frequency;
        private String format;

        public Builder preferenceId(Long preferenceId) {
            this.preferenceId = preferenceId;
            return this;
        }

        public Builder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder genre(String genre) {
            this.genre = genre;
            return this;
        }

        public Builder frequency(String frequency) {
            this.frequency = frequency;
            return this;
        }

        public Builder format(String format) {
            this.format = format;
            return this;
        }

        public Builder copy(UserPreference preference) {
            this.preferenceId = preference.preferenceId;
            this.userId = preference.userId;
            this.genre = preference.genre;
            this.frequency = preference.frequency;
            this.format = preference.format;
            return this;
        }

        public UserPreference build() {
            return new UserPreference(this);
        }
    }
}


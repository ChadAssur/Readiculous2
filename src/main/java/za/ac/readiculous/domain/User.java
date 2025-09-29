package za.ac.readiculous.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    private String lastName; // NEW FIELD
    private String email;
    private String password;

    protected User() {}  // For JPA

    private User(Builder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.lastName = builder.lastName; // NEW
        this.email = builder.email;
        this.password = builder.password;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getLastName() { // NEW GETTER
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    public static class Builder {
        private Integer userId;
        private String name;
        private String lastName; // NEW
        private String email;
        private String password;

        public Builder userId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder lastName(String lastName) { // NEW
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

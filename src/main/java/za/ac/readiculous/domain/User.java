package za.ac.readiculous.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String name;
    private String lastName;
    private String email;
    private String password;

    protected User() {}  // For JPA

    private User(Builder builder) {
        this.userId = builder.userId;
        this.name = builder.name;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.password = builder.password;
    }

    public Integer getUserId() { return userId; }
    public String getName() { return name; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    public void changePassword(String newPassword) { this.password = newPassword; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() { return Objects.hash(userId); }

    public static class Builder {
        private Integer userId;
        private String name;
        private String lastName;
        private String email;
        private String password;

        public Builder userId(Integer userId) { this.userId = userId; return this; }
        public Builder name(String name) { this.name = name; return this; }
        public Builder lastName(String lastName) { this.lastName = lastName; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder password(String password) { this.password = password; return this; }

        public User build() { return new User(this); }
    }
}

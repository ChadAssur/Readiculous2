package za.ac.readiculous.domain;



import java.util.Objects;

public class User {


    private Integer userId;


    private String name;


    private String email;


    private String password;

    // Constructors
    protected User() {}  // For JPA

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters (no setters to maintain immutability and aggregate root control)
    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Domain Behavior (example)
    public void changePassword(String newPassword) {
        // Add za.ac.readiculous.domain validation logic here
        this.password = newPassword;
    }

    // Equality (Entity Identity)
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
}


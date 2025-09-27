package za.ac.readiculous.factory;

import za.ac.readiculous.domain.User;

public class UserFactory {

    public static User createUser(Integer userId, String name, String lastName, String email, String password) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name is required.");
        }

        if (lastName == null || lastName.isEmpty()) { // NEW VALIDATION
            throw new IllegalArgumentException("Last name is required.");
        }

        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("A valid email is required.");
        }

        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long.");
        }

        return new User.Builder()
                .userId(userId)
                .name(name)
                .lastName(lastName) // NEW
                .email(email)
                .password(password)
                .build();
    }
}

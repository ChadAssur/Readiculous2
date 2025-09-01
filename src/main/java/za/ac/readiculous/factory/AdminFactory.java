package za.ac.readiculous.factory;

import za.ac.readiculous.domain.Admin;

public class AdminFactory {

    public static Admin createAdmin(String firstName, String lastName, String email, String password) {
        return new Admin.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(password)
                .setRole("ADMIN") // default role
                .build();
    }
}

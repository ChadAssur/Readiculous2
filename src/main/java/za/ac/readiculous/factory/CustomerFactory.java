package za.ac.readiculous.factory;

import za.ac.readiculous.domain.Customer;

public class CustomerFactory {

    public static Customer createCustomer(String firstName, String lastName, String email, String password) {
        return new Customer.Builder()
                .SetfirstName(firstName)
                .SetlastName(lastName)
                .SetEmail(email)
                .SetPassword(password)
                .SetRole("USER") // default role
                .build();
    }

    // Optional: factory method for admin role
    public static Customer createAdmin(String firstName, String lastName, String email, String password) {
        return new Customer.Builder()
                .SetfirstName(firstName)
                .SetlastName(lastName)
                .SetEmail(email)
                .SetPassword(password)
                .SetRole("ADMIN")
                .build();
    }
}


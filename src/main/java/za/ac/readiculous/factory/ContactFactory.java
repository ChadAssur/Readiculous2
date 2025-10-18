
package za.ac.readiculous.factory;

import za.ac.readiculous.domain.Contact;
import java.time.LocalDate;

public class ContactFactory {

    public static Contact createContact(String firstName,
                                        String lastName,
                                        String email,
                                        String phone,
                                        String address,
                                        String preferredContactMethod,
                                        String notes) {

        return new Contact.Builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .phone(phone)
                .address(address)
                .preferredContactMethod(preferredContactMethod != null ? preferredContactMethod : "EMAIL")
                .memberSince(LocalDate.now())
                .notes(notes)
                .build();
    }
}

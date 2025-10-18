package za.ac.readiculous.service;

import za.ac.readiculous.domain.Contact;
import java.util.List;
import java.util.Optional;

public interface IContactService {

    Contact createContact(String firstName,
                          String lastName,
                          String email,
                          String phone,
                          String address,
                          String preferredContactMethod,
                          String notes);

    List<Contact> getAllContacts();

    Optional<Contact> getContactById(Integer id);

    Optional<Contact> getContactByEmail(String email);

    boolean existsByEmail(String email);

    void deleteContact(Integer id);
}


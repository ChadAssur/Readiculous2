package za.ac.readiculous.service;

import org.springframework.stereotype.Service;
import za.ac.readiculous.domain.Contact;
import za.ac.readiculous.factory.ContactFactory;
import za.ac.readiculous.repository.ContactRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // Create and save a contact
    public Contact createContact(String firstName,
                                 String lastName,
                                 String email,
                                 String phone,
                                 String address,
                                 String preferredContactMethod,
                                 String notes) {

        Contact contact = ContactFactory.createContact(
                firstName,
                lastName,
                email,
                phone,
                address,
                preferredContactMethod,
                notes
        );

        return contactRepository.save(contact);
    }

    // Retrieve all contacts
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    // Retrieve a contact by ID
    public Optional<Contact> getContactById(Integer id) {
        return contactRepository.findById(id);
    }

    // Retrieve a contact by email
    public Optional<Contact> getContactByEmail(String email) {
        return contactRepository.findByEmail(email);
    }

    // Check if email exists
    public boolean existsByEmail(String email) {
        return contactRepository.existsByEmail(email);
    }

    // Delete a contact by ID
    public void deleteContact(Integer id) {
        contactRepository.deleteById(id);
    }
}


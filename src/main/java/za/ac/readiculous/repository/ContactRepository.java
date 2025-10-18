package za.ac.readiculous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.readiculous.domain.Contact;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

    // Find a contact by email
    Optional<Contact> findByEmail(String email);

    // Check if a contact with this email exists
    boolean existsByEmail(String email);
}


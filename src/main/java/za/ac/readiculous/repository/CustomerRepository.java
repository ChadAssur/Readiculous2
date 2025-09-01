package za.ac.readiculous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.readiculous.domain.Customer;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    // Find a customer by email
    Optional<Customer> findByEmail(String email);

    // Check if a customer with this email exists
    boolean existsByEmail(String email);
}


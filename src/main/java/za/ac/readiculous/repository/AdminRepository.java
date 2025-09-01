package za.ac.readiculous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.readiculous.domain.Admin;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    // Find an admin by email
    Optional<Admin> findByEmail(String email);

    // Check if an admin with this email exists
    boolean existsByEmail(String email);
}

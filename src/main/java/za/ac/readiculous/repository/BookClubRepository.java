package za.ac.readiculous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.readiculous.domain.BookClub;

@Repository
public interface BookClubRepository extends JpaRepository<BookClub, Long> {
    // Custom query methods can be defined here if needed
    // For example, find by message or messageId
    //Optional<Message> findByMessage(String message)
}

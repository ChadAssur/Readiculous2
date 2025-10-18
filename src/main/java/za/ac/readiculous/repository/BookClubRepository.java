package za.ac.readiculous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.readiculous.domain.BookClub;

@Repository
public interface BookClubRepository extends JpaRepository<BookClub, Integer> {
    // Custom queries if needed
}

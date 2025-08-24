package za.ac.readiculous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.readiculous.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}


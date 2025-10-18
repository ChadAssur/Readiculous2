package za.ac.readiculous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.readiculous.domain.Discussion;

@Repository
public interface DiscussionRepository extends JpaRepository<Discussion, Long> {
}

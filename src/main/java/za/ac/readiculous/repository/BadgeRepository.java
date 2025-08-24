package za.ac.readiculous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.readiculous.domain.Badge;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Long> {
}


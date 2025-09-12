package za.ac.readiculous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.readiculous.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}

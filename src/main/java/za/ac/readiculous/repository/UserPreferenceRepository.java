package za.ac.readiculous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.readiculous.domain.UserPreference;

import java.util.List;

@Repository
public interface UserPreferenceRepository extends JpaRepository<UserPreference, Long> {

    // Find preferences by userId
    List<UserPreference> findByUserId(Integer userId);

    // Optional: You can add more custom queries if needed in the future
}


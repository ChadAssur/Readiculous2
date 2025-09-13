package za.ac.readiculous.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.readiculous.domain.JoinPage;

@Repository
public interface JoinPageRepository extends JpaRepository<JoinPage, Long> {
}


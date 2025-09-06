package za.ac.readiculous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.readiculous.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

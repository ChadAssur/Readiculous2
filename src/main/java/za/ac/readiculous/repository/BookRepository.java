package za.ac.readiculous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.readiculous.domain.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}

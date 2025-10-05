package za.ac.readiculous.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.readiculous.domain.Book;
import za.ac.readiculous.domain.User;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Search by title (case-insensitive)
    List<Book> findByTitleContainingIgnoreCase(String title);

    // Search by author (case-insensitive)
    List<Book> findByAuthorContainingIgnoreCase(String author);

    // Search by genre (case-insensitive)
    List<Book> findByGenreIgnoreCase(String genre);

    // Search by year published
    List<Book> findByYearPublished(int yearPublished);

    // 🔹 New: Find all books for a specific user
    List<Book> findByUser(User user);

    // 🔹 New: Find all books for a specific userId (optional alternative)
    List<Book> findByUser_UserId(Integer userId);
}

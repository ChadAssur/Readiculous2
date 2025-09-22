package za.ac.readiculous.service;

/* IBookService.java
Author: [Your Name]
Date: [Today’s Date]
*/

import za.ac.readiculous.domain.Book;
import java.util.List;

public interface IBookService {

    Book create(Book book);

    Book read(Long id);

    Book update(Book book);

    boolean delete(Long id);

    List<Book> getAll();

    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByGenre(String genre);

    List<Book> findByYearPublished(int yearPublished);
}

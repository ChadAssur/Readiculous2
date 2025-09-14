package za.ac.readiculous.service;

import za.ac.readiculous.domain.Book;
import java.util.List;

public interface IBookService extends IService<Book, Long> {
    List<Book> getAll();
}
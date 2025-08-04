package za.ac.readiculous.service;

/* BookClubService class.java
Author: Brezano Liebenberg (230463886)
Date:31 July 2025
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.readiculous.domain.BookClub;
import za.ac.readiculous.repository.BookClubRepository;

import java.util.List;

@Service
public class BookClubService implements IBookClubService {

    private BookClubRepository repository;

    @Autowired
    BookClubService(BookClubRepository repository) {
        this.repository = repository;
    }

    @Override
    public BookClub create(BookClub bookClub) {
        return this.repository.save(bookClub);
    }

    @Override
    public BookClub read(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public BookClub update(BookClub bookClub) {
        return this.repository.save(bookClub);
    }

    @Override
    public boolean delete(Long id) {
        this.repository.deleteById(id);
        return true;
    }

    @Override
    public List<BookClub> getAll() {
        return this.repository.findAll();
    }
}

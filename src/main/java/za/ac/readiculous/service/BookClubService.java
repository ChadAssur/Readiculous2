package za.ac.readiculous.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.readiculous.domain.BookClub;
import za.ac.readiculous.repository.BookClubRepository;

import java.util.List;

@Service
public class BookClubService implements IBookClubService {

    private final BookClubRepository repository;

    @Autowired
    public BookClubService(BookClubRepository repository) {
        this.repository = repository;
    }

    @Override
    public BookClub create(BookClub bookClub) { return repository.save(bookClub); }

    @Override
    public BookClub read(Integer id) { return repository.findById(id).orElse(null); }

    @Override
    public BookClub update(BookClub bookClub) { return repository.save(bookClub); }

    @Override
    public boolean delete(Integer id) { repository.deleteById(id); return true; }

    @Override
    public List<BookClub> getAll() { return repository.findAll(); }

    @Override
    public BookClub findById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}

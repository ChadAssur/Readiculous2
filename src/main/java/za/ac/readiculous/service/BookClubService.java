package za.ac.readiculous.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.readiculous.domain.BookClub;
import za.ac.readiculous.factory.BookClubFactory;
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
    public BookClub create(BookClub club) {
        BookClub newClub = BookClubFactory.createBookClub(
                club.getClubId(),
                club.getOrganizerId(),
                club.getClubName(),
                club.getClubDescription(),
                club.getClubGenre(),
                club.getMemberList(),
                club.getScheduleMeeting()
        );
        return repository.create(newClub);
    }

    @Override
    public BookClub read(long clubId) {
        return repository.read(clubId);
    }

    @Override
    public BookClub update(BookClub club) {
        return repository.update(club);
    }

    @Override
    public boolean delete(long clubId) {
        return repository.delete(clubId);
    }

    @Override
    public List<BookClub> getAll() {
        return repository.getAll();
    }
}

package za.ac.readiculous.service;

import za.ac.readiculous.domain.BookClub;

import java.util.List;

public interface IBookClubService {
    BookClub create(BookClub club);
    BookClub read(long clubId);
    BookClub update(BookClub club);
    boolean delete(long clubId);
    List<BookClub> getAll();
}

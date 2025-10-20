package za.ac.readiculous.service;

import za.ac.readiculous.domain.BookClub;
import java.util.List;

public interface IBookClubService extends IService<BookClub, Integer> {
    List<BookClub> getAll();
    BookClub findById(Integer id);
}

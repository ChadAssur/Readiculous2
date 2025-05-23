package za.ac.readiculous.repository;

import za.ac.readiculous.domain.BookClub;

import java.util.*;

public class BookClubRepository {
    private static BookClubRepository repository = null;
    private final Map<Long, BookClub> bookClubDB;

    private BookClubRepository() {
        this.bookClubDB = new HashMap<>();
    }

    public static BookClubRepository getRepository() {
        if (repository == null) {
            repository = new BookClubRepository();
        }
        return repository;
    }

    public BookClub create(BookClub bookClub) {
        if (!bookClubDB.containsKey(bookClub.getClubId())) {
            bookClubDB.put(bookClub.getClubId(), bookClub);
        }
        return bookClubDB.get(bookClub.getClubId());
    }

    public BookClub read(long clubId) {
        return bookClubDB.get(clubId);
    }

    public BookClub update(BookClub bookClub) {
        if (bookClubDB.containsKey(bookClub.getClubId())) {
            bookClubDB.put(bookClub.getClubId(), bookClub);
            return bookClub;
        }
        return null;
    }

    public boolean delete(long clubId) {
        BookClub removed = bookClubDB.remove(clubId);
        return removed != null;
    }

    public List<BookClub> getAll() {
        return new ArrayList<>(bookClubDB.values());
    }
}

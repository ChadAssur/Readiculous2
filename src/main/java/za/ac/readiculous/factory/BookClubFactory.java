package za.ac.readiculous.factory;

import za.ac.readiculous.domain.BookClub;
import za.ac.readiculous.domain.User;
import za.ac.readiculous.util.Helper;

import java.time.LocalDateTime;

/**
 * Factory class for creating BookClub instances.
 */
public class BookClubFactory {

    /**
     * Creates a new BookClub instance using the Builder pattern.
     * Returns null if any required parameter is invalid.
     *
     * @param clubName        Name of the book club
     * @param clubDescription Description of the book club
     * @param createdAt       Creation timestamp
     * @param owner           Owner (User) of the club
     * @return BookClub instance or null if invalid input
     */
    public static BookClub createBookClub(String clubName, String clubDescription, LocalDateTime createdAt, User owner) {
        if (Helper.isStringNullOrEmpty(clubName) ||
                Helper.isStringNullOrEmpty(clubDescription) ||
                Helper.isDateNull(createdAt) ||
                Helper.isObjectNull(owner)) {
            return null;
        }

        return new BookClub.Builder()
                .setClubName(clubName)
                .setClubDescription(clubDescription)
                .setCreatedAt(createdAt)
                .setUser(owner)  // owner uses Integer ID internally
                .build();
    }
}

package za.ac.readiculous.factory;

/* BookClubFactory.java
Author: Brezano Liebenberg (230463886)
Date: 30 July 2025
*/

import za.ac.readiculous.domain.BookClub;
import za.ac.readiculous.domain.EventManagement;
import za.ac.readiculous.domain.User;
import za.ac.readiculous.util.Helper;

import java.time.LocalDateTime;

public class BookClubFactory {

    public static BookClub createBookClub( String clubName, String clubDescription, LocalDateTime createdAt, User owner) {
        if (
                Helper.isStringNullOrEmpty(clubName) || Helper.isStringNullOrEmpty(clubDescription) ||
                Helper.isDateNull(createdAt) || Helper.isObjectNull(owner)) {
            return null;
        }

       // long clubId = Helper.generateId();

        return new BookClub.Builder()

                .setClubName(clubName)
                .setClubDescription(clubDescription)
                .setCreatedAt(createdAt)
                .setUser(owner)
                .build();
    }

//    public static BookClub createBookClub2(long clubId, long organizerId,
//                                           String clubName, String clubDescription, LocalDateTime createdAt) {
//        if (!Helper.isValidLong(clubId) || !Helper.isValidLong(organizerId) ||
//                Helper.isStringNullOrEmpty(clubName) || Helper.isStringNullOrEmpty(clubDescription) ||
//                Helper.isDateNull(createdAt)) {
//            return null;
//        }
//
//        return new BookClub.Builder()
//                .setClubId(clubId)
//                .setOrganizerId(organizerId)
//                .setClubName(clubName)
//                .setClubDescription(clubDescription)
//                .setCreatedAt(createdAt)
//                .build();
//    }
}

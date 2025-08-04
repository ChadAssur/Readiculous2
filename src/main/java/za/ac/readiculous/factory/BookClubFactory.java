package za.ac.readiculous.factory;

/* BookClubFactory.java
Author: Brezano Liebenberg (230463886)
Date:30 July 2025
*/

import za.ac.readiculous.domain.BookClub;
import za.ac.readiculous.domain.EventManagement;
import za.ac.readiculous.util.Helper;

import java.time.LocalDateTime;

public class BookClubFactory {
    public static BookClub createBookClub(long clubId, long organizerId, String clubName, String clubDescription, String clubGenre, LocalDateTime createdAt, String memberList, EventManagement eventManagement) {
        if(!Helper.isValidLong(clubId) || !Helper.isValidLong(organizerId) || Helper.isStringNullOrEmpty(clubName) ||
            Helper.isStringNullOrEmpty(clubDescription) || Helper.isStringNullOrEmpty(clubGenre) || Helper.isDateNull(createdAt) ||
            Helper.isStringNullOrEmpty(memberList) || Helper.isObjectNull(eventManagement))
        {return null;}

        return new BookClub.Builder()
                .setClubId(clubId)
                .setOrganizerId(organizerId)
                .setClubName(clubName)
                .setClubDescription(clubDescription)
                .setClubGenre(clubGenre)
                .setCreatedAt(createdAt)
                .setMemberList(memberList)
                .setScheduleMeeting(eventManagement)
                .build();
    }

    public static BookClub createBookClub2(long clubId, long organizerId, String clubName, String clubDescription, String clubGenre, LocalDateTime createdAt, String memberList) {
        if(!Helper.isValidLong(clubId) || !Helper.isValidLong(organizerId) || Helper.isStringNullOrEmpty(clubName) ||
                Helper.isStringNullOrEmpty(clubDescription) || Helper.isStringNullOrEmpty(clubGenre) || Helper.isDateNull(createdAt) ||
                Helper.isStringNullOrEmpty(memberList))
        {return null;}

        return new BookClub.Builder()
                .setClubId(clubId)
                .setOrganizerId(organizerId)
                .setClubName(clubName)
                .setClubDescription(clubDescription)
                .setClubGenre(clubGenre)
                .setCreatedAt(createdAt)
                .setMemberList(memberList)
                .build();
    }
}

package za.ac.readiculous.factory;

import za.ac.readiculous.domain.BookClub;
import za.ac.readiculous.domain.EventManagement;
import za.ac.readiculous.util.Helper;

import java.time.LocalDateTime;

public class BookClubFactory {

    public static BookClub createBookClub(
            long clubId,
            long organizerId,
            String clubName,
            String clubDescription,
            String clubGenre,
            String memberList,
            EventManagement scheduleMeeting
    ) {

        if (!Helper.isValidId(clubId)) return null;
        if (!Helper.isValidId(organizerId)) return null;
        if (Helper.isNullOrEmpty(clubName)) return null;
        if (Helper.isNullOrEmpty(clubDescription)) return null;
        if (Helper.isNullOrEmpty(clubGenre)) return null;
        if (Helper.isNullOrEmpty(memberList)) return null;

        return new BookClub.Builder()
                .setClubId(clubId)
                .setOrganizerId(organizerId)
                .setClubName(Helper.capitalize(clubName))
                .setClubDescription(clubDescription.trim())
                .setClubGenre(Helper.capitalize(clubGenre))
                .setCreatedAt(LocalDateTime.now())
                .setMemberList(memberList.trim())
                .setScheduleMeeting(scheduleMeeting)
                .build();
    }
}

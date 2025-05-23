
package za.ac.readiculous.factory;

import za.ac.readiculous.domain.BookClub;
import za.ac.readiculous.domain.EventManagement;

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
        return new BookClub.Builder()
                .setClubId(clubId)
                .setOrganizerId(organizerId)
                .setClubName(clubName)
                .setClubDescription(clubDescription)
                .setClubGenre(clubGenre)
                .setCreatedAt(LocalDateTime.now())
                .setMemberList(memberList)
                .setScheduleMeeting(scheduleMeeting)
                .build();
    }
}

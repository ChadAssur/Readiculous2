package za.ac.readiculous.factory;

import za.ac.readiculous.domain.JoinPage;

public class JoinPageFactory {

    public static JoinPage createJoinPage(Long joinId, String memberName, String email, Long clubId) {
        if (memberName == null || memberName.isEmpty()) {
            throw new IllegalArgumentException("Member name cannot be null or empty");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (clubId == null) {
            throw new IllegalArgumentException("ClubId cannot be null");
        }

        return new JoinPage.Builder()
                .joinId(joinId)
                .memberName(memberName)
                .email(email)
                .clubId(clubId)
                .build();
    }
}


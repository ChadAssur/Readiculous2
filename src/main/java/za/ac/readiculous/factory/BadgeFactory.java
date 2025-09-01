package za.ac.readiculous.factory;

import za.ac.readiculous.domain.Badge;
import java.time.LocalDate;

public class BadgeFactory {

    public static Badge createBadge(long badgeId, String name, String description, LocalDate awardedDate, long userId) {
        return new Badge.Builder()
                .setBadgeId(badgeId)
                .setName(name)
                .setDescription(description)
                .setAwardedDate(awardedDate)
                .setUserId(userId)
                .build();
    }
}


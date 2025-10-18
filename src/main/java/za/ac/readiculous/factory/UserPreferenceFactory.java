package za.ac.readiculous.factory;

import za.ac.readiculous.domain.UserPreference;

public class UserPreferenceFactory {

    /**
     * Factory method to create a UserPreference instance
     * @param userId The ID of the user
     * @param genre Favorite genre
     * @param frequency Reading frequency
     * @param format Preferred format
     * @return a new UserPreference instance
     */
    public static UserPreference createUserPreference(Integer userId, String genre, String frequency, String format) {
        return new UserPreference.Builder()
                .userId(userId)
                .genre(genre)
                .frequency(frequency)
                .format(format)
                .build();
    }
}

package za.ac.readiculous.factory;

import za.ac.readiculous.domain.Discussion;
import za.ac.readiculous.util.Helper;

import java.util.ArrayList;
import java.util.List;

public class DiscussionFactory {

    /**
     * Creates a Discussion instance.
     *
     * @param discussionId The discussion ID
     * @param title        The title of the discussion
     * @param description  The description
     * @param likes        Initial like count
     * @param author       Author name
     * @param comments     List of comments (can be null)
     * @return Discussion instance or null if validation fails
     */
    public static Discussion createDiscussion(Long discussionId,
                                              String title,
                                              String description,
                                              int likes,
                                              String author,
                                              List<String> comments) {
        // Validate inputs
        if (!Helper.isValidLong(discussionId) ||
                Helper.isStringNullOrEmpty(title) ||
                Helper.isStringNullOrEmpty(description) ||
                Helper.isStringNullOrEmpty(author)) {
            return null;
        }

        // Ensure comments is not null
        if (comments == null) {
            comments = new ArrayList<>();
        }

        return new Discussion.Builder()
                .setDiscussionId(discussionId)
                .setTitle(title)
                .setDescription(description)
                .setLikes(likes)
                .setAuthor(author)
                .setComments(comments)
                .build();
    }
}

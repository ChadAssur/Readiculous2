package za.ac.readiculous.factory;

import za.ac.readiculous.domain.Discussion;
import za.ac.readiculous.util.Helper;


public class DiscussionFactory {

    public static Discussion createDiscussion(Long discussionId, String title, String description, int likes, String author, String comment) {
        if (!Helper.isValidLong(discussionId) || !Helper.isStringNullOrEmpty(title) || Helper.isStringNullOrEmpty(description) || Helper.isStringNullOrEmpty(author)) {
            return null;
        }

        return new Discussion.Builder()
                .setDiscussionId(discussionId)
                .setTitle(title)
                .setDescription(description)
                .setLikes(likes)
                .setAuthor(author)
                .setComment(comment)
                .build();
    }
}

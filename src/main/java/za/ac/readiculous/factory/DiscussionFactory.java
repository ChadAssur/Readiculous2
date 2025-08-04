package za.ac.readiculous.factory;

import za.ac.cput.Domain.Discussion;

/*
 * Author: Mpotseng Heisi (222309792)
 */
public class DiscussionFactory {

    public static Discussion createDiscussion(String discussionId, String content, int views, int likes, String poll, String tags, String link) {
        if (discussionId == null || discussionId.isEmpty() ||
                content == null || content.isEmpty()) {
            return null;
        }

        return new Discussion.Builder()
                .setDiscussionId(discussionId)
                .setContent(content)
                .setViews(views)
                .setLikes(likes)
                .setPoll(poll)
                .setTags(tags)
                .setLink(link)
                .build();
    }
}

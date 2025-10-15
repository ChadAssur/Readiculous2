package za.ac.readiculous.service;

import za.ac.readiculous.domain.Discussion;
import java.util.List;

public interface IDiscussionService extends IService<Discussion, Long> {

    // Get all discussions
    List<Discussion> getAll();

    // Increment likes for a discussion
    Discussion likeDiscussion(Long id);

    // Add a comment to a discussion
    Discussion addComment(Long id, String comment);
}

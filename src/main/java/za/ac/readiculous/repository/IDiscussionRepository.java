package za.ac.readiculous.repository;

import za.ac.cput.Domain.Discussion;

import java.util.List;

public interface IDiscussionRepository {
    Discussion create(Discussion discussion);
    Discussion read(String discussionId);
    Discussion update(Discussion discussion);
    boolean delete(String discussionId);
    List<Discussion> getAll();
}

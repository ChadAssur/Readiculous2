package za.ac.readiculous.repository;

import za.ac.readiculous.domain.Discussion;

import java.util.ArrayList;
import java.util.List;

/*
 * Author: Mpotseng Heisi (222309792)
 */
public class DiscussionRepository implements IDiscussionRepository {

    private static DiscussionRepository repository = null;
    private final List<Discussion> discussionList;

    private DiscussionRepository() {
        this.discussionList = new ArrayList<>();
    }

    public static DiscussionRepository getInstance() {
        if (repository == null) {
            repository = new DiscussionRepository();
        }
        return repository;
    }

    @Override
    public Discussion create(Discussion discussion) {
        if (discussion == null || discussion.getDiscussionId() == null) {
            return null;
        }

        if (exists(discussion.getDiscussionId())) {
            return null; // prevent duplicates
        }

        discussionList.add(discussion);
        return discussion;
    }

    @Override
    public Discussion read(String discussionId) {
        for (Discussion discussion : discussionList) {
            if (discussion.getDiscussionId().equals(discussionId)) {
                return discussion;
            }
        }
        return null;
    }

    @Override
    public Discussion update(Discussion discussion) {
        if (discussion == null || discussion.getDiscussionId() == null) {
            return null;
        }

        int index = findIndexByDiscussionId(discussion.getDiscussionId());
        if (index == -1) {
            return null; // not found
        }

        discussionList.set(index, discussion);
        return discussion;
    }

    @Override
    public boolean delete(String discussionId) {
        int index = findIndexByDiscussionId(discussionId);

        if (index == -1) {
            return false; // not found
        }

        discussionList.remove(index);
        return true;
    }

    @Override
    public List<Discussion> getAll() {
        return new ArrayList<>(discussionList);
    }

    private int findIndexByDiscussionId(String discussionId) {
        for (int i = 0; i < discussionList.size(); i++) {
            if (discussionList.get(i).getDiscussionId().equals(discussionId)) {
                return i;
            }
        }
        return -1;
    }

    private boolean exists(String discussionId) {
        return findIndexByDiscussionId(discussionId) != -1;
    }
}

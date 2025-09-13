package za.ac.readiculous.service;


import za.ac.readiculous.domain.Discussion;
import java.util.List;

public interface IDiscussionService extends IService<Discussion, Long> {
    List<Discussion> getAll();
}

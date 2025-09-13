package za.ac.readiculous.service;



import za.ac.readiculous.domain.JoinPage;

import java.util.List;

public interface IJoinPageService {
    JoinPage create(JoinPage joinPage);
    JoinPage read(Long id);
    JoinPage update(JoinPage joinPage);
    boolean delete(Long id);
    List<JoinPage> getAll();
}


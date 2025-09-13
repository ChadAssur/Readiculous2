package za.ac.readiculous.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.readiculous.domain.Discussion;
import za.ac.readiculous.repository.DiscussionRepository;

import java.util.List;

@Service
public class DiscussionService implements IDiscussionService {

    private final DiscussionRepository repository;

    @Autowired
    public DiscussionService(DiscussionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Discussion create(Discussion discussion) {
        return this.repository.save(discussion);
    }

    @Override
    public Discussion read(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Discussion update(Discussion discussion) {
        return this.repository.save(discussion);
    }

    @Override
    public boolean delete(Long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Discussion> getAll() {
        return this.repository.findAll();
    }
}

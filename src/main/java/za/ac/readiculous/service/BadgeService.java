package za.ac.readiculous.service;

import org.springframework.stereotype.Service;
import za.ac.readiculous.domain.Badge;
import za.ac.readiculous.repository.BadgeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BadgeService {

    private final BadgeRepository repository;

    public BadgeService(BadgeRepository repository) {
        this.repository = repository;
    }

    public Badge save(Badge badge) {
        return repository.save(badge);
    }

    public List<Badge> findAll() {
        return repository.findAll();
    }

    public Optional<Badge> findById(Long id) {
        return repository.findById(id);
    }

    public Badge update(Badge badge) {
        return repository.save(badge);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}


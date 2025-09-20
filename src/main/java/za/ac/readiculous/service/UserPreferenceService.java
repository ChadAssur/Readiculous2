package za.ac.readiculous.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.readiculous.domain.UserPreference;
import za.ac.readiculous.repository.UserPreferenceRepository;

import java.util.List;

@Service
public class UserPreferenceService implements IUserPreferenceService {

    private final UserPreferenceRepository repository;

    @Autowired
    public UserPreferenceService(UserPreferenceRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserPreference create(UserPreference preference) {
        return repository.save(preference);
    }

    @Override
    public UserPreference read(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public UserPreference update(UserPreference preference) {
        return repository.save(preference);
    }

    @Override
    public boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<UserPreference> getAll() {
        return repository.findAll();
    }

    @Override
    public List<UserPreference> getByUserId(Integer userId) {
        return repository.findByUserId(userId);
    }
}

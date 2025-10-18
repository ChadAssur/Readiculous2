package za.ac.readiculous.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.readiculous.domain.User;
import za.ac.readiculous.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User read(Integer id) {
        Optional<User> optionalUser = repository.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public User update(User user) {
        // Ensure the user exists before updating
        if (user.getUserId() != null && repository.existsById(user.getUserId())) {
            return repository.save(user);
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User changePassword(Integer id, String newPassword) {
        Optional<User> optionalUser = repository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.changePassword(newPassword); // Correct method from User class
            return repository.save(user);
        }
        return null;
    }

    // Optional: authenticate user
    public User login(String email, String password) {
        return repository.findAll().stream()
                .filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}

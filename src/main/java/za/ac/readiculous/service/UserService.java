package za.ac.readiculous.service;

/* UserService.java
Author: Ameer Arai
Date: 12 September 2025
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.readiculous.domain.User;
import za.ac.readiculous.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements IUserService {

    private UserRepository repository;

    @Autowired
    UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User create(User user) {
        return this.repository.save(user);
    }

    @Override
    public User read(Integer id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public User update(User user) {
        return this.repository.save(user);
    }

    @Override
    public boolean delete(Integer id) {
        this.repository.deleteById(id);
        return true;
    }

    @Override
    public List<User> getAll() {
        return this.repository.findAll();
    }

    @Override
    public User changePassword(Integer id, String newPassword) {
        User user = this.repository.findById(id).orElse(null);
        if (user != null) {
            user.changePassword(newPassword);
            return this.repository.save(user);
        }
        return null;
    }
}

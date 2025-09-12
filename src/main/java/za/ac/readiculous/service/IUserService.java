package za.ac.readiculous.service;

import za.ac.readiculous.domain.User;

import java.util.List;

public interface IUserService {
    User create(User user);
    User read(Integer id);
    User update(User user);
    boolean delete(Integer id);
    List<User> getAll();
    User changePassword(Integer id, String newPassword);
}

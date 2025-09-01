package za.ac.readiculous.service;

import za.ac.readiculous.domain.Admin;

import java.util.List;
import java.util.Optional;

public interface IAdminService {

    Admin createAdmin(String firstName, String lastName, String email, String password);

    List<Admin> getAllAdmins();

    Optional<Admin> getAdminById(Long id);

    Optional<Admin> getAdminByEmail(String email);

    boolean existsByEmail(String email);

    void deleteAdmin(Long id);
}

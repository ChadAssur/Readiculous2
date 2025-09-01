package za.ac.readiculous.service;

import org.springframework.stereotype.Service;
import za.ac.readiculous.domain.Admin;
import za.ac.readiculous.factory.AdminFactory;
import za.ac.readiculous.repository.AdminRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    // Create and save an admin
    public Admin createAdmin(String firstName, String lastName, String email, String password) {
        Admin admin = AdminFactory.createAdmin(firstName, lastName, email, password);
        return adminRepository.save(admin);
    }

    // Retrieve all admins
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Retrieve an admin by ID
    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    // Retrieve an admin by email
    public Optional<Admin> getAdminByEmail(String email) {
        return adminRepository.findByEmail(email);
    }

    // Check if email exists
    public boolean existsByEmail(String email) {
        return adminRepository.existsByEmail(email);
    }

    // Delete an admin by ID
    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}

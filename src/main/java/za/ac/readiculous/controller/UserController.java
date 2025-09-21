package za.ac.readiculous.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.readiculous.domain.User;
import za.ac.readiculous.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/User")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        return service.create(user);
    }

    @GetMapping("/read/{id}")
    public User read(@PathVariable Integer id) {
        return service.read(id);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user) {
        return service.update(user);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id) {
        return service.delete(id);
    }

    @GetMapping("/getAll")
    public List<User> getAll() {
        return service.getAll();
    }

    @PutMapping("/changePassword/{id}")
    public User changePassword(@PathVariable Integer id, @RequestParam String newPassword) {
        return service.changePassword(id, newPassword);
    }

    // --- New Login API ---
    @PostMapping("/login")
    public User login(@RequestBody LoginRequest loginRequest) {
        User user = service.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (user == null) {
            throw new RuntimeException("Invalid email or password");
        }
        return user;
    }

    // DTO for login
    public static class LoginRequest {
        private String email;
        private String password;

        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}

package za.ac.readiculous.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.readiculous.domain.UserPreference;
import za.ac.readiculous.service.IUserPreferenceService;

import java.util.List;

@RestController
@RequestMapping("/api/UserPreference")
@CrossOrigin(origins = "http://localhost:5173")
public class UserPreferenceController {

    private final IUserPreferenceService service;

    @Autowired
    public UserPreferenceController(IUserPreferenceService service) {
        this.service = service;
    }

    // Create a new preference
    @PostMapping("/create")
    public UserPreference create(@RequestBody UserPreference preference) {
        return service.create(preference);
    }

    // Read a preference by id
    @GetMapping("/read/{id}")
    public UserPreference read(@PathVariable Long id) {
        return service.read(id);
    }

    // Update a preference
    @PutMapping("/update")
    public UserPreference update(@RequestBody UserPreference preference) {
        return service.update(preference);
    }

    // Delete a preference
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Long id) {
        return service.delete(id);
    }

    // Get all preferences
    @GetMapping("/getAll")
    public List<UserPreference> getAll() {
        return service.getAll();
    }

    // Get preferences by userId
    @GetMapping("/user/{userId}")
    public List<UserPreference> getByUserId(@PathVariable Integer userId) {
        return service.getByUserId(userId);
    }
}


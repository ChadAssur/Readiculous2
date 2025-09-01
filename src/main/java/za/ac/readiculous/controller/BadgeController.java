package za.ac.readiculous.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.readiculous.domain.Badge;
import za.ac.readiculous.service.BadgeService;

import java.util.List;

@RestController
@RequestMapping("/api/badges")
public class BadgeController {

    private final BadgeService service;

    public BadgeController(BadgeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Badge> create(@RequestBody Badge badge) {
        return ResponseEntity.ok(service.save(badge));
    }

    @GetMapping
    public ResponseEntity<List<Badge>> getAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Badge> getById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Badge> update(@PathVariable Long id, @RequestBody Badge badge) {
        if (!service.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        badge = new Badge.Builder()
                .setBadgeId(id)
                .setName(badge.getName())
                .setDescription(badge.getDescription())
                .setAwardedDate(badge.getAwardedDate())
                .setUserId(badge.getUserId())
                .build();
        return ResponseEntity.ok(service.update(badge));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


package za.ac.readiculous.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.readiculous.domain.Discussion;
import za.ac.readiculous.service.DiscussionService;

import java.util.List;

@RestController
@RequestMapping("/api/discussions")
public class DiscussionController {

    private final DiscussionService service;

    public DiscussionController(DiscussionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Discussion> create(@RequestBody Discussion discussion) {
        return ResponseEntity.ok(service.create(discussion));
    }

    @GetMapping
    public ResponseEntity<List<Discussion>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Discussion> getById(@PathVariable Long id) {
        Discussion discussion = service.read(id);
        return (discussion != null)
                ? ResponseEntity.ok(discussion)
                : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Discussion> update(@PathVariable Long id, @RequestBody Discussion discussion) {
        Discussion existing = service.read(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        discussion = new Discussion.Builder()
                .setDiscussionId(id)
                .setTitle(discussion.getTitle())
                .setDescription(discussion.getDescription())
                .setLikes(discussion.getLikes())
                .setAuthor(discussion.getAuthor())
                .setComment(discussion.getComment())
                .build();
        return ResponseEntity.ok(service.update(discussion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}

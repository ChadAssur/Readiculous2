package za.ac.readiculous.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.readiculous.domain.Discussion;
import za.ac.readiculous.service.DiscussionService;

import java.util.List;

@RestController
@RequestMapping("/api/Discussion")
@CrossOrigin(origins = "http://localhost:5173")
public class DiscussionController {

    private final DiscussionService service;

    public DiscussionController(DiscussionService service) {
        this.service = service;
    }

    // Create a new discussion
    @PostMapping
    public ResponseEntity<Discussion> create(@RequestBody Discussion discussion) {
        return ResponseEntity.ok(service.create(discussion));
    }

    // Get all discussions
    @GetMapping
    public ResponseEntity<List<Discussion>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    // Get a discussion by ID
    @GetMapping("/{id}")
    public ResponseEntity<Discussion> getById(@PathVariable Long id) {
        Discussion discussion = service.read(id);
        return (discussion != null)
                ? ResponseEntity.ok(discussion)
                : ResponseEntity.notFound().build();
    }

    // Update a discussion
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
                .setComments(discussion.getComments())
                .build();
        return ResponseEntity.ok(service.update(discussion));
    }

    // Delete a discussion
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    // Increment likes
    @PostMapping("/{id}/like")
    public ResponseEntity<Discussion> likeDiscussion(@PathVariable Long id) {
        Discussion updated = service.likeDiscussion(id);
        return (updated != null)
                ? ResponseEntity.ok(updated)
                : ResponseEntity.notFound().build();
    }

    // Add a comment
    @PostMapping("/{id}/comment")
    public ResponseEntity<Discussion> addComment(@PathVariable Long id, @RequestBody CommentPayload payload) {
        Discussion updated = service.addComment(id, payload.getComment());
        return (updated != null)
                ? ResponseEntity.ok(updated)
                : ResponseEntity.notFound().build();
    }

    // DTO for comment payload
    public static class CommentPayload {
        private String comment;

        public String getComment() { return comment; }
        public void setComment(String comment) { this.comment = comment; }
    }
}

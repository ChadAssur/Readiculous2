package za.ac.readiculous.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Discussion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long discussionId;
    private String title;
    private String description;
    private int likes;
    private String author;

    @ElementCollection
    private List<String> comments = new ArrayList<>();

    protected Discussion() {}

    private Discussion(Builder builder) {
        this.discussionId = builder.discussionId;
        this.title = builder.title;
        this.description = builder.description;
        this.likes = builder.likes;
        this.author = builder.author;
        this.comments = builder.comments;
    }

    // Getters
    public Long getDiscussionId() { return discussionId; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public int getLikes() { return likes; }
    public String getAuthor() { return author; }
    public List<String> getComments() { return comments; }

    // Setters (needed for DiscussionService)
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setLikes(int likes) { this.likes = likes; }
    public void setAuthor(String author) { this.author = author; }
    public void setComments(List<String> comments) { this.comments = comments; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discussion)) return false;
        Discussion that = (Discussion) o;
        return likes == that.likes &&
                Objects.equals(discussionId, that.discussionId) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(author, that.author) &&
                Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discussionId, title, description, likes, author, comments);
    }

    @Override
    public String toString() {
        return "Discussion{" +
                "discussionId=" + discussionId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", likes=" + likes +
                ", author='" + author + '\'' +
                ", comments=" + comments +
                '}';
    }

    // Builder
    public static class Builder {
        private Long discussionId;
        private String title;
        private String description;
        private int likes;
        private String author;
        private List<String> comments = new ArrayList<>();

        public Builder setDiscussionId(Long discussionId) { this.discussionId = discussionId; return this; }
        public Builder setTitle(String title) { this.title = title; return this; }
        public Builder setDescription(String description) { this.description = description; return this; }
        public Builder setLikes(int likes) { this.likes = likes; return this; }
        public Builder setAuthor(String author) { this.author = author; return this; }
        public Builder setComments(List<String> comments) { this.comments = comments; return this; }

        public Builder copy(Discussion discussion) {
            this.discussionId = discussion.discussionId;
            this.title = discussion.title;
            this.description = discussion.description;
            this.likes = discussion.likes;
            this.author = discussion.author;
            this.comments = discussion.comments;
            return this;
        }

        public Discussion build() {
            return new Discussion(this);
        }
    }
}

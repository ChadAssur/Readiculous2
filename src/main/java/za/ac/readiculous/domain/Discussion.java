package za.ac.readiculous.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String comment;

    // Default constructor (JPA requirement)
    protected Discussion() {}

    private Discussion(Builder builder) {
        this.discussionId = builder.discussionId;
        this.title = builder.title;
        this.description = builder.description;
        this.likes = builder.likes;
        this.author = builder.author;
        this.comment = builder.comment;
    }

    // Getters
    public Long getDiscussionId() {
        return discussionId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getLikes() {
        return likes;
    }

    public String getAuthor() {
        return author;
    }

    public String getComment() {
        return comment;
    }

    // equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discussion that = (Discussion) o;
        return likes == that.likes &&
                Objects.equals(discussionId, that.discussionId) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(author, that.author) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discussionId, title, description, likes, author, comment);
    }

    // toString
    @Override
    public String toString() {
        return "Discussion{" +
                "discussionId=" + discussionId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", likes=" + likes +
                ", author='" + author + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    // Builder
    public static class Builder {
        private Long discussionId;
        private String title;
        private String description;
        private int likes;
        private String author;
        private String comment;

        public Builder setDiscussionId(Long discussionId) {
            this.discussionId = discussionId;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setLikes(int likes) {
            this.likes = likes;
            return this;
        }

        public Builder setAuthor(String author) {
            this.author = author;
            return this;
        }

        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder copy(Discussion discussion) {
            this.discussionId = discussion.discussionId;
            this.title = discussion.title;
            this.description = discussion.description;
            this.likes = discussion.likes;
            this.author = discussion.author;
            this.comment = discussion.comment;
            return this;
        }

        public Discussion build() {
            return new Discussion(this);
        }
    }
}

package za.ac.readiculous.domain;

public class Discussion {
    private Long discussionId;
    private String title;
    private String description;
    private int likes;
    private String author;
    private String comment;

    private Discussion() {}

    private Discussion(Builder builder) {
        this.discussionId = builder.discussionId;
        this.title = builder.title;
        this.description = builder.description;
        this.likes = builder.likes;
        this.author = builder.author;
        this.comment = builder.comment;
    }

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

    @Override
    public String toString() {
        return "Discussion{" +
                "discussionId='" + discussionId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", likes=" + likes +
                ", author='" + author + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

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

        public Discussion build() {
            return new Discussion(this);
        }
    }
}

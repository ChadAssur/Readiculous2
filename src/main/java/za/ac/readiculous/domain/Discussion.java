package za.ac.readiculous.domain;

public class Discussion {
    private String discussionId;
    private String content;
    private int views;
    private int likes;
    private String poll;
    private String tags;
    private String link;

    private Discussion() {}

    private Discussion(Builder builder) {
        this.discussionId = builder.discussionId;
        this.content = builder.content;
        this.views = builder.views;
        this.likes = builder.likes;
        this.poll = builder.poll;
        this.tags = builder.tags;
        this.link = builder.link;
    }

    public String getDiscussionId() {
        return discussionId;
    }

    public String getContent() {
        return content;
    }

    public int getViews() {
        return views;
    }

    public int getLikes() {
        return likes;
    }

    public String getPoll() {
        return poll;
    }

    public String getTags() {
        return tags;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "Discussion{" +
                "discussionId='" + discussionId + '\'' +
                ", content='" + content + '\'' +
                ", views=" + views +
                ", likes=" + likes +
                ", poll='" + poll + '\'' +
                ", tags='" + tags + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

    public static class Builder {
        private String discussionId;
        private String content;
        private int views;
        private int likes;
        private String poll;
        private String tags;
        private String link;

        public Builder setDiscussionId(String discussionId) {
            this.discussionId = discussionId;
            return this;
        }

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder setViews(int views) {
            this.views = views;
            return this;
        }

        public Builder setLikes(int likes) {
            this.likes = likes;
            return this;
        }

        public Builder setPoll(String poll) {
            this.poll = poll;
            return this;
        }

        public Builder setTags(String tags) {
            this.tags = tags;
            return this;
        }

        public Builder setLink(String link) {
            this.link = link;
            return this;
        }

        public Discussion build() {
            return new Discussion(this);
        }
    }
}


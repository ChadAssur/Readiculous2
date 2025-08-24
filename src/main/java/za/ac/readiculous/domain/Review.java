package za.ac.readiculous.domain;

import java.time.LocalDate;

public class Review {

    private long reviewId;
    private long bookId;
    private long userId;
    private int rating;
    private String comment;
    private LocalDate reviewDate;

    // Constructor
    public Review(long reviewId, long bookId, long userId,
                  int rating, String comment, LocalDate reviewDate) {
        this.reviewId = reviewId;
        this.bookId = bookId;
        this.userId = userId;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    // Getters
    public long getReviewId() { return reviewId; }
    public long getBookId() { return bookId; }
    public long getUserId() { return userId; }
    public int getRating() { return rating; }
    public String getComment() { return comment; }
    public LocalDate getReviewDate() { return reviewDate; }

    // Builder
    public static class Builder {
        private long reviewId;
        private long bookId;
        private long userId;
        private int rating;
        private String comment;
        private LocalDate reviewDate;

        public Builder setReviewId(long reviewId) {
            this.reviewId = reviewId;
            return this;
        }

        public Builder setBookId(long bookId) {
            this.bookId = bookId;
            return this;
        }

        public Builder setUserId(long userId) {
            this.userId = userId;
            return this;
        }

        public Builder setRating(int rating) {
            this.rating = rating;
            return this;
        }

        public Builder setComment(String comment) {
            this.comment = comment;
            return this;
        }

        public Builder setReviewDate(LocalDate reviewDate) {
            this.reviewDate = reviewDate;
            return this;
        }

        public Review build() {
            return new Review(reviewId, bookId, userId, rating, comment, reviewDate);
        }
    }
}


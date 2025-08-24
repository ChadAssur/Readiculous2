package za.ac.readiculous.factory;

import za.ac.readiculous.domain.Review;
import java.time.LocalDate;

public class ReviewFactory {

    public static Review createReview(long reviewId, long bookId, long userId, int rating, String comment, LocalDate reviewDate) {
        return new Review.Builder()
                .setReviewId(reviewId)
                .setBookId(bookId)
                .setUserId(userId)
                .setRating(rating)
                .setComment(comment)
                .setReviewDate(reviewDate)
                .build();
    }
}


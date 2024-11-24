package com.umcpractice.chapter_5.domain.review.converter;

import com.umcpractice.chapter_5.domain.review.dto.ReviewResponse;
import com.umcpractice.chapter_5.domain.review.entity.Review;

public class ReviewConverter {

    public static ReviewResponse.ReviewDto toDto(Review review){

        return new ReviewResponse.ReviewDto(
                review.getBody(),
                review.getScore()
        );
    }
}

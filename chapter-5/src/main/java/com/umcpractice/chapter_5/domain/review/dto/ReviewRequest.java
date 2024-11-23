package com.umcpractice.chapter_5.domain.review.dto;

import com.umcpractice.chapter_5.domain.review.entity.Review;
import com.umcpractice.chapter_5.validation.annotation.StoreExists;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ReviewRequest {

    @NotNull(message = "Score는 필수입니다.")
    private float score;

    @NotEmpty(message = "내용은 필수입니다.")
    private String body;

    @StoreExists
    @NotNull(message = "가게 ID는 필수입니다.")
    private Long storeId;

    public Review toEntity() {
        return Review.builder()
                .body(body)
                .score(score)
                .build();
    }
}
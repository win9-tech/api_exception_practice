package com.umcpractice.chapter_5.domain.review.dto;

import com.umcpractice.chapter_5.domain.store.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReviewResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewDto{
          String body;
          float score;
          Store storeId;
    }
}

package com.umcpractice.chapter_5.domain.store.service;

import com.umcpractice.chapter_5.domain.review.entity.Review;
import org.springframework.data.domain.Page;

public interface StoreService {

    Page<Review> getReviewList(Long storeId, Integer page);
}
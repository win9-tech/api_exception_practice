package com.umcpractice.chapter_5.domain.review.service;

import com.umcpractice.chapter_5.domain.review.dto.ReviewRequest;
import com.umcpractice.chapter_5.domain.review.entity.Review;
import org.springframework.web.multipart.MultipartFile;

public interface ReviewService {
    Review add(ReviewRequest reviewRequest, Long storeId);
}

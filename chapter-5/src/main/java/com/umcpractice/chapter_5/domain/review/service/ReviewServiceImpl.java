package com.umcpractice.chapter_5.domain.review.service;

import com.umcpractice.chapter_5.domain.review.dto.ReviewRequest;
import com.umcpractice.chapter_5.domain.review.entity.Review;
import com.umcpractice.chapter_5.domain.review.repository.ReviewRepository;
import com.umcpractice.chapter_5.domain.store.entity.Store;
import com.umcpractice.chapter_5.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;

    @Override
    public Review add(ReviewRequest reviewRequest, MultipartFile file, Long storeId) {
        Review review = reviewRequest.toEntity();
        Store store = storeRepository.findById(storeId).orElseThrow(RuntimeException::new);
        // 맴버는 JWT토큰쓸때
        // 이미지 S3로 저장 url반환하면 그때 review_image 테이블에 저장 여기서는 S3 연결안해서 작성안함
        review.setStore(store);
        return reviewRepository.save(review);
    }
}
package com.umcpractice.chapter_5.domain.review.service;

import com.umcpractice.chapter_5.domain.member.repository.MemberRepository;
import com.umcpractice.chapter_5.domain.review.dto.ReviewRequest;
import com.umcpractice.chapter_5.domain.review.entity.Review;
import com.umcpractice.chapter_5.domain.review.repository.ReviewRepository;
import com.umcpractice.chapter_5.domain.store.entity.Store;
import com.umcpractice.chapter_5.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    public Review add(ReviewRequest reviewRequest, Long storeId) {
        Review review = reviewRequest.toEntity();
        Store store = storeRepository.findById(storeId).orElseThrow(RuntimeException::new);
        review.setStore(store);
        review.setMember(memberRepository.getReferenceById(1L));
        return reviewRepository.save(review);
    }
}
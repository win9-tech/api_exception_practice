package com.umcpractice.chapter_5.domain.store.service;

import com.umcpractice.chapter_5.domain.mission.entity.Mission;
import com.umcpractice.chapter_5.domain.mission.repository.MissionRepository;
import com.umcpractice.chapter_5.domain.review.entity.Review;
import com.umcpractice.chapter_5.domain.review.repository.ReviewRepository;
import com.umcpractice.chapter_5.domain.store.entity.Store;
import com.umcpractice.chapter_5.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).orElseThrow();
        return reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).orElseThrow();
        return missionRepository.findAllByStore(store, PageRequest.of(page, 10));
    }
}
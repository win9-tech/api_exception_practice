package com.umcpractice.chapter_5.domain.store.controller;

import com.umcpractice.chapter_5.api.ApiResponse;
import com.umcpractice.chapter_5.domain.review.dto.ReviewResponse;
import com.umcpractice.chapter_5.domain.review.entity.Review;
import com.umcpractice.chapter_5.domain.store.converter.StoreConverter;
import com.umcpractice.chapter_5.domain.store.service.StoreService;
import com.umcpractice.chapter_5.validation.annotation.StoreExists;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController implements StoreApiPresentation{

    private final StoreService storeService;

    @GetMapping("/{storeId}/reviews")
    public ApiResponse<ReviewResponse.ReviewPreViewListDTO> getReviewList(@StoreExists @PathVariable(name = "storeId") Long storeId,@RequestParam(name = "page") Integer page){
        Page<Review> reviewList = storeService.getReviewList(storeId,page);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
    }
}
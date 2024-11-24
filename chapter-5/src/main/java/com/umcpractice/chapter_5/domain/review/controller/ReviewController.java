package com.umcpractice.chapter_5.domain.review.controller;

import com.umcpractice.chapter_5.api.ApiResponse;
import com.umcpractice.chapter_5.domain.review.converter.ReviewConverter;
import com.umcpractice.chapter_5.domain.review.dto.ReviewRequest;
import com.umcpractice.chapter_5.domain.review.dto.ReviewResponse;
import com.umcpractice.chapter_5.domain.review.service.ReviewService;
import com.umcpractice.chapter_5.validation.annotation.StoreExists;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("{storeId}")
    public ApiResponse<ReviewResponse.ReviewDto> add(
            @RequestBody @Valid ReviewRequest reviewRequest,
            @PathVariable @StoreExists Long storeId) {
        return ApiResponse.onSuccess(ReviewConverter.toDto(reviewService.add(reviewRequest, storeId)));
    }
}
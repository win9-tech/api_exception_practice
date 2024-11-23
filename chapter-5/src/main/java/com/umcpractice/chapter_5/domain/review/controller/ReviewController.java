package com.umcpractice.chapter_5.domain.review.controller;

import com.umcpractice.chapter_5.api.ApiResponse;
import com.umcpractice.chapter_5.domain.review.converter.ReviewConverter;
import com.umcpractice.chapter_5.domain.review.dto.ReviewRequest;
import com.umcpractice.chapter_5.domain.review.dto.ReviewResponse;
import com.umcpractice.chapter_5.domain.review.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping(consumes = "multipart/form-data")
    public ApiResponse<ReviewResponse.ReviewDto> add(
            @Valid @RequestPart("Text") ReviewRequest reviewRequest,
            @RequestPart("File") MultipartFile file,
            @RequestPart("StoreId") Long storeId
    ) {
        return ApiResponse.onSuccess(ReviewConverter.toDto(reviewService.add(reviewRequest, file, storeId)));
    }
}
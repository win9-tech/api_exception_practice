package com.umcpractice.chapter_5.domain.member.converter;

import com.umcpractice.chapter_5.domain.member.dto.request.MemberRequestDto;
import com.umcpractice.chapter_5.domain.member.dto.response.MemberResponseDto;
import com.umcpractice.chapter_5.domain.member.entity.Member;
import com.umcpractice.chapter_5.domain.review.dto.ReviewResponse;
import com.umcpractice.chapter_5.domain.review.entity.Review;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDto.JoinResultDTO toDto(Member member){
        return MemberResponseDto.JoinResultDTO.builder()
                .memberId((member.getId()))
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDto.JoinDto request){

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(request.getGender())
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .build();
    }
    private static ReviewResponse.ReviewPreViewDTO reviewPreviewDTO(Review review) {
        return ReviewResponse.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .body(review.getBody())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static ReviewResponse.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList) {

        List<ReviewResponse.ReviewPreViewDTO> reviewPreViewDTOList = reviewList
                .stream()
                .map(MemberConverter::reviewPreviewDTO)
                .collect(Collectors.toList());

        return ReviewResponse.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
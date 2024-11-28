package com.umcpractice.chapter_5.domain.member.service;

import com.umcpractice.chapter_5.domain.member.dto.request.MemberRequestDto;
import com.umcpractice.chapter_5.domain.member.entity.Member;
import com.umcpractice.chapter_5.domain.review.entity.Review;
import org.springframework.data.domain.Page;

public interface MemberService {

    Member join(MemberRequestDto.JoinDto requestDto);

    Page<Review> getReviewList(Long memberId, Integer page);
}
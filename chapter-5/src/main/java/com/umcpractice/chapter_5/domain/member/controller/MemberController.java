package com.umcpractice.chapter_5.domain.member.controller;

import com.umcpractice.chapter_5.api.ApiResponse;
import com.umcpractice.chapter_5.domain.member.converter.MemberConverter;
import com.umcpractice.chapter_5.domain.member.dto.request.MemberRequestDto;
import com.umcpractice.chapter_5.domain.member.dto.response.MemberResponseDto;
import com.umcpractice.chapter_5.domain.member.entity.Member;
import com.umcpractice.chapter_5.domain.member.service.MemberService;
import com.umcpractice.chapter_5.domain.member_mission.dto.MemberMissionResponse;
import com.umcpractice.chapter_5.domain.member_mission.entity.MemberMission;
import com.umcpractice.chapter_5.domain.review.dto.ReviewResponse;
import com.umcpractice.chapter_5.domain.review.entity.Review;
import com.umcpractice.chapter_5.validation.annotation.MemberExists;
import com.umcpractice.chapter_5.validation.annotation.PageAvailable;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController implements MemberApiPresentation{

    private final MemberService memberService;

    @PostMapping
    public ApiResponse<MemberResponseDto.JoinResultDTO> join(@RequestBody @Valid MemberRequestDto.JoinDto request){
        Member member = memberService.join(request);
        return ApiResponse.onSuccess(MemberConverter.toDto(member));
    }

    @GetMapping("{memberId}/reviews")
    public ApiResponse<ReviewResponse.ReviewPreViewListDTO> getReviewList(
            @MemberExists @PathVariable(name = "memberId") Long memberId,
            @PageAvailable @RequestParam(name = "page") Integer page
    ){
        Page<Review> reviewList = memberService.getReviewList(memberId, page);
        return ApiResponse.onSuccess(MemberConverter.reviewPreViewListDTO(reviewList));
    }

    @GetMapping("{memberId}/missions")
    public ApiResponse<MemberMissionResponse.MemberMissionPreViewListDTO> getInProgressMissionList(
            @MemberExists @PathVariable(name = "memberId") Long memberId,
            @PageAvailable @RequestParam(name = "page") Integer page
    ){
        Page<MemberMission> memberMissionList = memberService.getInProgressMissionList(memberId, page);
        return ApiResponse.onSuccess(MemberConverter.memberMissionPreViewListDTO(memberMissionList));
    }
}
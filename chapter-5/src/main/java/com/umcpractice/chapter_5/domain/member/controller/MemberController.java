package com.umcpractice.chapter_5.domain.member.controller;

import com.umcpractice.chapter_5.api.ApiResponse;
import com.umcpractice.chapter_5.domain.member.convertor.MemberConverter;
import com.umcpractice.chapter_5.domain.member.dto.request.MemberRequestDto;
import com.umcpractice.chapter_5.domain.member.dto.response.MemberResponse;
import com.umcpractice.chapter_5.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ApiResponse<MemberResponse.MemberDto> createMember(@RequestBody MemberRequestDto requestDto) {
        return ApiResponse.onSuccess(MemberConverter.toDto(memberService.createMember(requestDto)));
    }

    @GetMapping
    public ApiResponse<MemberResponse.MemberDto> getMember(@RequestBody MemberRequestDto requestDto) {
        return ApiResponse.onSuccess(MemberConverter.toDto(memberService.getMember(requestDto)));
    }
}
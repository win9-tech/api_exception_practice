package com.umcpractice.chapter_5.domain.member.service;

import com.umcpractice.chapter_5.domain.member.dto.request.MemberRequestDto;
import com.umcpractice.chapter_5.domain.member.dto.response.MemberResponse;

public interface MemberService {

    MemberResponse.MemberDto createMember(MemberRequestDto memberRequestDto);

    MemberResponse.MemberDto getMember(MemberRequestDto memberRequestDto);
}

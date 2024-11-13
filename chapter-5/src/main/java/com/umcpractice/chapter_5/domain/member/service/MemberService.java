package com.umcpractice.chapter_5.domain.member.service;

import com.umcpractice.chapter_5.domain.member.dto.request.MemberRequestDto;
import com.umcpractice.chapter_5.domain.member.entity.Member;

public interface MemberService {

    Member createMember(MemberRequestDto memberRequestDto);

    Member getMember(MemberRequestDto memberRequestDto);
}

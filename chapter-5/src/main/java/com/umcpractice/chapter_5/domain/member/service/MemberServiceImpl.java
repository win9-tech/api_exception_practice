package com.umcpractice.chapter_5.domain.member.service;

import com.umcpractice.chapter_5.domain.member.convertor.MemberConverter;
import com.umcpractice.chapter_5.domain.member.dto.request.MemberRequestDto;
import com.umcpractice.chapter_5.domain.member.dto.response.MemberResponse;
import com.umcpractice.chapter_5.domain.member.entity.Member;
import com.umcpractice.chapter_5.domain.member.repository.MemberRepositoryJPA;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepositoryJPA memberRepositoryJPA;

    @Override
    public MemberResponse.MemberDto createMember(MemberRequestDto memberRequestDto) {
        Member member = memberRequestDto.toEntity();
        return MemberConverter.toDto(memberRepositoryJPA.save(member));
    }

    @Override
    public MemberResponse.MemberDto getMember(MemberRequestDto memberRequestDto) {
        return MemberConverter.toDto(memberRepositoryJPA.findByName(memberRequestDto.getName()));
    }
}
package com.umcpractice.chapter_5.domain.member.service;

import com.umcpractice.chapter_5.domain.member.dto.request.MemberRequestDto;
import com.umcpractice.chapter_5.domain.member.entity.Member;
import com.umcpractice.chapter_5.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public Member createMember(MemberRequestDto memberRequestDto) {
        Member member = memberRequestDto.toEntity();
        return memberRepository.save(member);
    }

    @Override
    @Transactional(readOnly = true)
    public Member getMember(MemberRequestDto memberRequestDto) {
        return memberRepository.findByName(memberRequestDto.getName());
    }
}
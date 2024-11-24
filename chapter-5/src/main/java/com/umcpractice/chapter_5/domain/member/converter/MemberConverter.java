package com.umcpractice.chapter_5.domain.member.converter;

import com.umcpractice.chapter_5.domain.member.dto.request.MemberRequestDto;
import com.umcpractice.chapter_5.domain.member.dto.response.MemberResponseDto;
import com.umcpractice.chapter_5.domain.member.entity.Member;

import java.time.LocalDateTime;
import java.util.ArrayList;

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
}
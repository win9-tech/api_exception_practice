package com.umcpractice.chapter_5.domain.member.convertor;

import com.umcpractice.chapter_5.domain.member.dto.response.MemberResponse;
import com.umcpractice.chapter_5.domain.member.entity.Member;

public class MemberConverter {

    public static MemberResponse.MemberDto toDto(Member member){
        return new MemberResponse.MemberDto(
                member.getAge(),
                member.getName(),
                member.getEmail(),
                member.getGender(),
                member.getPoint());
    }
}
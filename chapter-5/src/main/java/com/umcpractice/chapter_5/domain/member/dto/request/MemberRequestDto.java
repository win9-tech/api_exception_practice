package com.umcpractice.chapter_5.domain.member.dto.request;

import com.umcpractice.chapter_5.domain.member.entity.Member;
import lombok.Getter;

@Getter
public class MemberRequestDto {

    private String age;
    private String name;
    private String email;
    private String gender;
    private String point;

    public Member toEntity() {
        return Member.builder()
                .age(age)
                .name(name)
                .email(email)
                .gender(gender)
                .point(point)
                .build();
    }
}
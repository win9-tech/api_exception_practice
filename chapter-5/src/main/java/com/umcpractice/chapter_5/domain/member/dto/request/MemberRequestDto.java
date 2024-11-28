package com.umcpractice.chapter_5.domain.member.dto.request;

import com.umcpractice.chapter_5.validation.annotation.ExistCategories;
import lombok.Getter;

import java.util.List;

public class MemberRequestDto {

    @Getter
    public static class JoinDto{
        String name;
        String gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String address;
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }
}
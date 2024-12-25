package com.umcpractice.chapter_5.domain.member.dto.request;

import com.umcpractice.chapter_5.enums.Role;
import com.umcpractice.chapter_5.validation.annotation.ExistCategories;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class MemberRequestDto {

    @Getter
    @Setter
    public static class JoinDto{
        String name;
        @Email
        String email;    // 이메일 필드 추가
        @NotBlank
        String password;    // 비밀번호 필드 추가
        String gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        String address;
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
        @NotNull
        Role role;
    }
}
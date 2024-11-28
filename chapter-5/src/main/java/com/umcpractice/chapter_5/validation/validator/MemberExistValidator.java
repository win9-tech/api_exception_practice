package com.umcpractice.chapter_5.validation.validator;

import com.umcpractice.chapter_5.domain.member.repository.MemberRepository;
import com.umcpractice.chapter_5.validation.annotation.MemberExists;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberExistValidator implements ConstraintValidator<MemberExists, Long> {

    private final MemberRepository memberRepository;

    @Override
    public boolean isValid(Long memberId, ConstraintValidatorContext constraintValidatorContext) {
        if(memberId == null){
            return false;
        }
        return memberRepository.existsById(memberId);
    }
}

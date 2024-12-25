package com.umcpractice.chapter_5.validation.validator;

import com.umcpractice.chapter_5.domain.member_mission.repository.MemberMissionRepository;
import com.umcpractice.chapter_5.validation.annotation.MissionStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MissionStatusValidator implements ConstraintValidator<MissionStatus, Long> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public void initialize(MissionStatus constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        return !memberMissionRepository.existsByMissionId(missionId);
    }
}
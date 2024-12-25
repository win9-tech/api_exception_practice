package com.umcpractice.chapter_5.validation.annotation;

import com.umcpractice.chapter_5.validation.validator.MissionStatusValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MissionStatusValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MissionStatus {

    String message() default "MISSION_STATUS_CONFLICT";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
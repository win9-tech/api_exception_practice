package com.umcpractice.chapter_5.validation.annotation;

import com.umcpractice.chapter_5.validation.validator.MemberExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MemberExistValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MemberExists {

    String message() default "MEMBER_NOT_FOUND";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

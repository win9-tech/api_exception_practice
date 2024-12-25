package com.umcpractice.chapter_5.validation.annotation;

import com.umcpractice.chapter_5.validation.validator.PageAvailableValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PageAvailableValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface PageAvailable {

    String message() default "NON_AVAILABLE_VALUE_PAGE";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

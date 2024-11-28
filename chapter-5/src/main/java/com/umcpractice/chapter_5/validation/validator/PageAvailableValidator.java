package com.umcpractice.chapter_5.validation.validator;


import com.umcpractice.chapter_5.validation.annotation.PageAvailable;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class PageAvailableValidator implements ConstraintValidator<PageAvailable, Integer> {

    @Override
    public void initialize(PageAvailable constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer page, ConstraintValidatorContext constraintValidatorContext) {
        return page != null && page >= 0;
    }
}
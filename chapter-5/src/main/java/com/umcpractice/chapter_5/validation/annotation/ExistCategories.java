package com.umcpractice.chapter_5.validation.annotation;

import com.umcpractice.chapter_5.validation.validator.CategoriesExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CategoriesExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistCategories {

    String message() default "FOOD_CATEGORY_NOT_FOUND";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
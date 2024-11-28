package com.umcpractice.chapter_5.validation.validator;

import com.umcpractice.chapter_5.domain.store.repository.StoreRepository;
import com.umcpractice.chapter_5.validation.annotation.StoreExists;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreExistsValidator implements ConstraintValidator<StoreExists, Long> {

    private final StoreRepository storeRepository;

    @Override
    public void initialize(StoreExists constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        if (storeId == null) {
            return false;
        }
        return storeRepository.existsById(storeId);
    }
}
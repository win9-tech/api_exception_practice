package com.umcpractice.chapter_5.domain.food_category.repository;

import com.umcpractice.chapter_5.domain.food_category.entity.FoodCategory;
import org.springframework.data.repository.CrudRepository;

public interface FoodCategoryRepository extends CrudRepository<FoodCategory, Long> {
}
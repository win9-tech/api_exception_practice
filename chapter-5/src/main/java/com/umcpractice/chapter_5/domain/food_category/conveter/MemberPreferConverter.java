package com.umcpractice.chapter_5.domain.food_category.conveter;

import com.umcpractice.chapter_5.domain.food_category.entity.FoodCategory;
import com.umcpractice.chapter_5.domain.member_prefer.MemberPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {

    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}

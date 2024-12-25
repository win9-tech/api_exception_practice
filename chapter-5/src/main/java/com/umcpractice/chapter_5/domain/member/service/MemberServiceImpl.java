package com.umcpractice.chapter_5.domain.member.service;

import com.umcpractice.chapter_5.api.code.status.ErrorStatus;
import com.umcpractice.chapter_5.domain.food_category.conveter.MemberPreferConverter;
import com.umcpractice.chapter_5.domain.food_category.entity.FoodCategory;
import com.umcpractice.chapter_5.domain.food_category.repository.FoodCategoryRepository;
import com.umcpractice.chapter_5.domain.member.converter.MemberConverter;
import com.umcpractice.chapter_5.domain.member.dto.request.MemberRequestDto;
import com.umcpractice.chapter_5.domain.member.entity.Member;
import com.umcpractice.chapter_5.domain.member.repository.MemberRepository;
import com.umcpractice.chapter_5.domain.member_mission.entity.MemberMission;
import com.umcpractice.chapter_5.domain.member_mission.repository.MemberMissionRepository;
import com.umcpractice.chapter_5.domain.member_prefer.MemberPrefer;
import com.umcpractice.chapter_5.domain.review.entity.Review;
import com.umcpractice.chapter_5.domain.review.repository.ReviewRepository;
import com.umcpractice.chapter_5.exception.handler.FoodCategoryHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService{

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;
    private final ReviewRepository reviewRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member join(MemberRequestDto.JoinDto request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        Member member = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> foodCategoryRepository.findById(category).orElseThrow(()
                        -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND))).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);
        memberPreferList.forEach(memberPrefer -> memberPrefer.setMember(member));

        return memberRepository.save(member);
    }

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        return reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
    }

    @Override
    public Page<MemberMission> getInProgressMissionList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        return memberMissionRepository.findAllByMemberAndStatus(member, "IN_PROGRESS", PageRequest.of(page, 10));
    }
}
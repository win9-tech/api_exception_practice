package com.umcpractice.chapter_5.domain.store.converter;

import com.umcpractice.chapter_5.domain.mission.dto.MissionResponse;
import com.umcpractice.chapter_5.domain.mission.entity.Mission;
import com.umcpractice.chapter_5.domain.review.dto.ReviewResponse;
import com.umcpractice.chapter_5.domain.review.entity.Review;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

    public static ReviewResponse.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return ReviewResponse.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static ReviewResponse.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){

        List<ReviewResponse.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return ReviewResponse.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }

    public static MissionResponse.MissionsPreViewDTO missionPreViewDTO(Mission mission){
        return MissionResponse.MissionsPreViewDTO.builder()
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .createdAt(mission.getCreatedAt())
                .missionSpec(mission.getMissionSpec())
                .build();

    }

    public static MissionResponse.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionList){

        List<MissionResponse.MissionsPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(StoreConverter::missionPreViewDTO).collect(Collectors.toList());

        return MissionResponse.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }


}
package com.umcpractice.chapter_5.domain.member_mission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

public class MemberMissionResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionDto{
        String storeName;
        int reward;
        Date deadline;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionPreViewDTO{
        String storeName;
        Long missionId;
        String status;
        Date deadline;
        String missionSpec;
        int reward;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberMissionPreViewListDTO{
        List<MemberMissionResponse.MemberMissionPreViewDTO> memberMissionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }
}
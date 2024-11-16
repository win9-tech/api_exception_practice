package com.umcpractice.chapter_5.domain.member_mission.converter;

import com.umcpractice.chapter_5.domain.member_mission.dto.MemberMissionResponse;
import com.umcpractice.chapter_5.domain.member_mission.entity.MemberMission;
import com.umcpractice.chapter_5.domain.mission.entity.Mission;
import com.umcpractice.chapter_5.domain.store.entity.Store;

public class MemberMissionConverter {

    public static MemberMissionResponse.MemberMissionDto convertToDto(MemberMission memberMission) {
        Mission mission = memberMission.getMission();
        Store store = mission.getStore();

        return MemberMissionResponse.MemberMissionDto.builder()
                .storeName(store.getName())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .build();
    }
}
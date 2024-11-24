package com.umcpractice.chapter_5.domain.mission.converter;

import com.umcpractice.chapter_5.domain.mission.dto.MissionResponse;
import com.umcpractice.chapter_5.domain.mission.entity.Mission;

public class MissionConverter {

    public static MissionResponse.MissionDto toDto(Mission mission) {
        return new MissionResponse.MissionDto(
                mission.getCreatedAt()
        );
    }
}

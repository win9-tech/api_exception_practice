package com.umcpractice.chapter_5.domain.mission.dto;

import com.umcpractice.chapter_5.domain.mission.entity.Mission;
import lombok.Getter;

import java.util.Date;

@Getter
public class MissionRequest {

    Date deadline;
    String missionSpec;
    int reward;

    public Mission toDto(){
        return Mission.builder()
                .deadline(deadline)
                .missionSpec(missionSpec)
                .reward(reward)
                .build();
    }
}

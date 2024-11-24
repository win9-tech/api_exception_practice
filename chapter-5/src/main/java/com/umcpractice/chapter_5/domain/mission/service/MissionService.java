package com.umcpractice.chapter_5.domain.mission.service;

import com.umcpractice.chapter_5.domain.mission.dto.MissionRequest;
import com.umcpractice.chapter_5.domain.mission.entity.Mission;

public interface MissionService {
    Mission add(MissionRequest missionRequest, Long storeId);
}

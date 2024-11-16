package com.umcpractice.chapter_5.domain.member_mission.service;

import com.umcpractice.chapter_5.domain.member_mission.entity.MemberMission;

import java.util.List;

public interface MemberMissionService {
    List<MemberMission> getInProgress(Long memberId, Long page, int size);

    List<MemberMission> getCompleted(Long memberId, Long page, int size);
}
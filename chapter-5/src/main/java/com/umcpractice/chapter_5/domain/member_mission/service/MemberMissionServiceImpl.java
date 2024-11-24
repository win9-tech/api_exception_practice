package com.umcpractice.chapter_5.domain.member_mission.service;

import com.umcpractice.chapter_5.domain.member.entity.Member;
import com.umcpractice.chapter_5.domain.member.repository.MemberRepository;
import com.umcpractice.chapter_5.domain.member_mission.entity.MemberMission;
import com.umcpractice.chapter_5.domain.member_mission.repository.MemberMissionRepository;
import com.umcpractice.chapter_5.domain.mission.entity.Mission;
import com.umcpractice.chapter_5.domain.mission.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;

    @Transactional(readOnly = true)
    @Override
    public List<MemberMission> getInProgress(Long memberId, Long page, int size) {
        Pageable pageable = PageRequest.of(page.intValue(), size, Sort.by(Sort.Direction.DESC, "updatedAt"));
        return memberMissionRepository.findByMemberIdAndStatusOrderByUpdatedAtDesc(memberId, "IN_PROGRESS", pageable).getContent();
    }

    @Transactional(readOnly = true)
    @Override
    public List<MemberMission> getCompleted(Long memberId, Long page, int size) {
        Pageable pageable = PageRequest.of(page.intValue(), size, Sort.by(Sort.Direction.DESC, "updatedAt"));
        return memberMissionRepository.findByMemberIdAndStatusOrderByUpdatedAtDesc(memberId, "COMPLETED", pageable).getContent();
    }

    @Override
    public MemberMission changeStatus(Long missionId) {
        Member member = memberRepository.getReferenceById(1L);
        Mission mission = missionRepository.findById(missionId).orElseThrow();

        MemberMission memberMission
                = MemberMission.builder()
                .member(member)
                .status("IN_PROGRESS")
                .mission(mission)
                .build();

        return memberMissionRepository.save(memberMission);
    }
}
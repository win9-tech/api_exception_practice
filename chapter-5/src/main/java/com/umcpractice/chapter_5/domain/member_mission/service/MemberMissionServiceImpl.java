package com.umcpractice.chapter_5.domain.member_mission.service;

import com.umcpractice.chapter_5.domain.member_mission.entity.MemberMission;
import com.umcpractice.chapter_5.domain.member_mission.repository.MemberMissionRepository;
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

    @Transactional(readOnly = true)
    @Override
    public List<MemberMission> getInProgress(Long memberId, Long page, int size) {
        Pageable pageable = PageRequest.of(page.intValue(), size, Sort.by(Sort.Direction.DESC, "updatedAt"));
        return memberMissionRepository.findByMemberIdAndStatusOrderByUpdatedAtDesc(memberId, "IN_PROGRESS", pageable).getContent();
    }
}
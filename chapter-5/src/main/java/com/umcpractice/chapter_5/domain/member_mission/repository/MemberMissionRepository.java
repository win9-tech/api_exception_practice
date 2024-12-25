package com.umcpractice.chapter_5.domain.member_mission.repository;

import com.umcpractice.chapter_5.domain.member.entity.Member;
import com.umcpractice.chapter_5.domain.member_mission.entity.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {

    Page<MemberMission> findByMemberIdAndStatusOrderByUpdatedAtDesc(Long memberId, String inProgress, Pageable pageable);

    boolean existsByMissionId(Long missionId);

    Page<MemberMission> findAllByMemberAndStatus(Member member, String inProgress, PageRequest of);
}
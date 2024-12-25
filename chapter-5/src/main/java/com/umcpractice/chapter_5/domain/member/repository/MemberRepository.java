package com.umcpractice.chapter_5.domain.member.repository;

import com.umcpractice.chapter_5.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

    Member findByName(String name);
}

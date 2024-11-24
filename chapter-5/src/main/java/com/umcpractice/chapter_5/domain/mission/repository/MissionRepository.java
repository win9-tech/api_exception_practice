package com.umcpractice.chapter_5.domain.mission.repository;

import com.umcpractice.chapter_5.domain.mission.entity.Mission;
import org.springframework.data.repository.CrudRepository;

public interface MissionRepository extends CrudRepository<Mission, Long> {
}

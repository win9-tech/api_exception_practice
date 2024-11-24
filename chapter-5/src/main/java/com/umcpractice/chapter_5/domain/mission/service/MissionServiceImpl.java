package com.umcpractice.chapter_5.domain.mission.service;

import com.umcpractice.chapter_5.domain.mission.dto.MissionRequest;
import com.umcpractice.chapter_5.domain.mission.entity.Mission;
import com.umcpractice.chapter_5.domain.mission.repository.MissionRepository;
import com.umcpractice.chapter_5.domain.store.entity.Store;
import com.umcpractice.chapter_5.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public Mission add(MissionRequest missionRequest, Long storeId) {

        Mission mission = missionRequest.toDto();
        Store store = storeRepository.findById(storeId).orElseThrow();
        mission.setStore(store);

        return missionRepository.save(mission);
    }
}

package com.umcpractice.chapter_5.domain.mission.controller;

import com.umcpractice.chapter_5.api.ApiResponse;
import com.umcpractice.chapter_5.domain.mission.converter.MissionConverter;
import com.umcpractice.chapter_5.domain.mission.dto.MissionRequest;
import com.umcpractice.chapter_5.domain.mission.dto.MissionResponse;
import com.umcpractice.chapter_5.domain.mission.service.MissionService;
import com.umcpractice.chapter_5.validation.annotation.StoreExists;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PostMapping("{storeId}")
    public ApiResponse<MissionResponse.MissionDto> add(
            @RequestBody @Valid MissionRequest missionRequest,
            @PathVariable @StoreExists Long storeId) {
        return ApiResponse.onSuccess(MissionConverter.toDto(missionService.add(missionRequest, storeId)));
    }
}
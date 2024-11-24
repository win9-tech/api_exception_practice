package com.umcpractice.chapter_5.domain.member_mission.controller;

import com.umcpractice.chapter_5.api.ApiResponse;
import com.umcpractice.chapter_5.domain.member_mission.converter.MemberMissionConverter;
import com.umcpractice.chapter_5.domain.member_mission.dto.MemberMissionResponse;
import com.umcpractice.chapter_5.domain.member_mission.service.MemberMissionService;
import com.umcpractice.chapter_5.validation.annotation.MissionStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/member-missions")
@RestController
@RequiredArgsConstructor
public class MemberMissionController {

    private final MemberMissionService memberMissionService;

    @GetMapping("/in-progress")
    public ApiResponse<List<MemberMissionResponse.MemberMissionDto>> getInProgress(@RequestParam Long memberId,
                                                                                   @RequestParam Long page) {
        return ApiResponse.onSuccess(memberMissionService.getInProgress(memberId, page, 3).stream()
                .map(MemberMissionConverter::convertToDto)
                .toList());
    }
    @GetMapping("/completed")
    public ApiResponse<List<MemberMissionResponse.MemberMissionDto>> getCompleted(@RequestParam Long memberId,
                                                                                   @RequestParam Long page) {
        return ApiResponse.onSuccess(memberMissionService.getCompleted(memberId, page, 3).stream()
                .map(MemberMissionConverter::convertToDto)
                .toList());
    }

    @PostMapping("{missionId}")
    public ApiResponse<MemberMissionResponse.MemberMissionDto> changeStatus(@PathVariable @MissionStatus Long missionId) {
        return ApiResponse.onSuccess(MemberMissionConverter.convertToDto(memberMissionService.changeStatus(missionId)));
    }
}
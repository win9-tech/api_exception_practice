package com.umcpractice.chapter_5.domain.member_mission.controller;

import com.umcpractice.chapter_5.api.ApiResponse;
import com.umcpractice.chapter_5.domain.member_mission.converter.MemberMissionConverter;
import com.umcpractice.chapter_5.domain.member_mission.dto.MemberMissionResponse;
import com.umcpractice.chapter_5.domain.member_mission.service.MemberMissionService;
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
}
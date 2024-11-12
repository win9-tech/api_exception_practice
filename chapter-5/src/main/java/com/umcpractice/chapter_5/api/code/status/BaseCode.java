package com.umcpractice.chapter_5.api.code.status;

import com.umcpractice.chapter_5.api.code.ReasonDto;

public interface BaseCode {

    ReasonDto getReason();

    ReasonDto getReasonHttpStatus();
}
package com.umcpractice.chapter_5.api.code.status;

import com.umcpractice.chapter_5.api.code.ErrorReasonDto;

public interface BaseErrorCode {

    ErrorReasonDto getReason();

    ErrorReasonDto getReasonHttpStatus();
}
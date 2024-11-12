package com.umcpractice.chapter_5.api.code.status;

import com.umcpractice.chapter_5.api.code.ErrorReasonDto;

public class ErrorStatus implements BaseErrorCode {

    @Override
    public ErrorReasonDto getReason() {
        return null;
    }

    @Override
    public ErrorReasonDto getReasonHttpStatus() {
        return null;
    }
}

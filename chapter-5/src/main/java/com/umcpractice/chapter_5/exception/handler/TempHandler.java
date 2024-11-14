package com.umcpractice.chapter_5.exception.handler;

import com.umcpractice.chapter_5.api.code.status.BaseErrorCode;
import com.umcpractice.chapter_5.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
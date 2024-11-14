package com.umcpractice.chapter_5.domain.temp.service;

import com.umcpractice.chapter_5.api.code.status.ErrorStatus;
import com.umcpractice.chapter_5.exception.handler.TempHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{

    @Override
    public void CheckFlag(Integer flag) {
        if (flag != 2)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
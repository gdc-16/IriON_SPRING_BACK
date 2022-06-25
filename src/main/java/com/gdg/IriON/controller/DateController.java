package com.gdg.IriON.controller;

import com.gdg.IriON.common.CommonResponse;
import com.gdg.IriON.dto.DateRequestDto;
import com.gdg.IriON.service.DateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/date")
@RestController
public class DateController {

    private final DateService dateService;

    @PostMapping("/inquiry")
    public CommonResponse<?> dateInquiry(DateRequestDto dateRequestDto) {
        dateService.dateInquiry(dateRequestDto);
        return CommonResponse.ok();
    }
}

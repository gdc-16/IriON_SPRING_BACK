package com.gdg.IriON.controller;

import com.gdg.IriON.common.CommonResponse;
import com.gdg.IriON.dto.DateRequestDto;
import com.gdg.IriON.service.DateService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/date")
@RestController
public class DateController {

    private final DateService dateService;

    @Operation(description = "데이트 문의")
    @PostMapping("/inquiry")
    public CommonResponse<?> dateInquiry(@RequestBody DateRequestDto dateRequestDto) {
        dateService.dateInquiry(dateRequestDto);
        return CommonResponse.ok();
    }
}

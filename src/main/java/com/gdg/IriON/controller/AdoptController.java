package com.gdg.IriON.controller;

import com.gdg.IriON.common.CommonResponse;
import com.gdg.IriON.dto.AdoptRequestDto;
import com.gdg.IriON.service.AdoptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/Adopt")
@RestController
public class AdoptController {

    private final AdoptService adoptService;

    @PostMapping("/inquiry")
    public CommonResponse<?> adoptInquiry(AdoptRequestDto adoptRequestDto) {
        return CommonResponse.ok(adoptService.adoptInquiry(adoptRequestDto));
    }


}

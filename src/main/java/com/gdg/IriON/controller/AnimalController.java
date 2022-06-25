package com.gdg.IriON.controller;

import com.gdg.IriON.common.CommonResponse;
import com.gdg.IriON.dto.FollowCancelRequestDto;
import com.gdg.IriON.dto.FollowRequestDto;
import com.gdg.IriON.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/animal")
@RequiredArgsConstructor
@RestController
public class AnimalController {

    private final AnimalService animalService;

    @PostMapping("/follow")
    public CommonResponse<?> followAnimal(@RequestBody FollowRequestDto followRequestDto) {
        animalService.follow(followRequestDto);
        return CommonResponse.ok();
    }

    @PostMapping("/cancel")
    public CommonResponse<?> CancelFollowAnimal(@RequestBody FollowCancelRequestDto followCancelRequestDto) {
        animalService.cancelFollow(followCancelRequestDto);
        return CommonResponse.ok();
    }

    @GetMapping("/follow/{id}")
    public CommonResponse<?> getFollowCount(@PathVariable Long id) {
        return CommonResponse.ok(animalService.getFollowCount(id));
    }
}

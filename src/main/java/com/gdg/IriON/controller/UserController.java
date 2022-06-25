package com.gdg.IriON.controller;

import com.gdg.IriON.common.CommonResponse;
import com.gdg.IriON.dto.QuizRequestDto;
import com.gdg.IriON.dto.UserLoginDto;
import com.gdg.IriON.dto.UserSignUpDto;
import com.gdg.IriON.service.QuizService;
import com.gdg.IriON.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;
    private final QuizService quizService;

    @PostMapping("/signup")
    public CommonResponse<?> signUp(@ModelAttribute @Valid UserSignUpDto userSignUpDto) {
        userService.signUp(userSignUpDto);
        return CommonResponse.ok();
    }

    @PostMapping("/login")
    public CommonResponse<?> login(@ModelAttribute @Valid UserLoginDto userLoginDto) {
        return CommonResponse.ok(userService.login(userLoginDto));
    }

    @PostMapping("/quiz")
    public CommonResponse<?> quiz(@RequestBody QuizRequestDto quizRequestDto) {
        return CommonResponse.ok(quizService.doQuiz(quizRequestDto));
    }


}

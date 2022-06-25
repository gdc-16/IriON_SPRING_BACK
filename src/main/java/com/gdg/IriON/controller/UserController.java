package com.gdg.IriON.controller;

import com.gdg.IriON.common.CommonResponse;
import com.gdg.IriON.dto.QuizRequestDto;
import com.gdg.IriON.dto.UserLoginDto;
import com.gdg.IriON.dto.UserSignUpDto;
import com.gdg.IriON.service.QuizService;
import com.gdg.IriON.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserService userService;
    private final QuizService quizService;

    @Operation(description = "회원가입")
    @Parameters({
            @Parameter(name = "name", description = "이름", required = true),
            @Parameter(name = "userid", description = "아이디", required = true),
            @Parameter(name = "password", description = "비밀번호", required = true),
            @Parameter(name = "phonenumber", description = "전화번호", required = true)
    })
    @PostMapping("/signup")
    public CommonResponse<?> signUp(@ModelAttribute @Valid UserSignUpDto userSignUpDto) {
        userService.signUp(userSignUpDto);
        return CommonResponse.ok();
    }

    @Operation(description = "로그인")
    @Parameters({
            @Parameter(name = "userid", description = "아이디", required = true),
            @Parameter(name = "password", description = "비밀번호", required = true)
    })
    @PostMapping("/login")
    public CommonResponse<?> login(@ModelAttribute @Valid UserLoginDto userLoginDto) {
        return CommonResponse.ok(userService.login(userLoginDto));
    }

    @Operation(description = "퀴즈 풀기")
    @PostMapping("/quiz")
    public CommonResponse<?> quiz(@RequestBody QuizRequestDto quizRequestDto) {
        return CommonResponse.ok(quizService.doQuiz(quizRequestDto));
    }


}

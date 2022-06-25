package com.gdg.IriON.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserLoginDto {

    @Schema(description = "유저 아이디", example = "nice111")
    @NotNull
    private String userId;

    @Schema(description = "유저 비밀번호", example = "1234")
    @NotNull
    private String password;
}

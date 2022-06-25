package com.gdg.IriON.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserSignUpDto {

    @NotNull
    private String name;

    @NotNull
    private String userId;

    @NotNull
    private String password;


    private String phoneNumber;
}

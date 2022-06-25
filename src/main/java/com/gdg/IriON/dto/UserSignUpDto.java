package com.gdg.IriON.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserSignUpDto {

    @NotNull
    private String name;

    @NotNull
    private String userId;

    @NotNull
    private String password;

    @NotNull
    private String phoneNumber;
}

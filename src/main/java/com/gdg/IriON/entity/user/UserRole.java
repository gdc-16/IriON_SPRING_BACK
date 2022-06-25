package com.gdg.IriON.entity.user;

import lombok.Getter;

@Getter
public enum UserRole {
    USER("USER"), CHIEF("CHIEF");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }
}

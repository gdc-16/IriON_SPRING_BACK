package com.gdg.IriON.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class QuizRequestDto {

    private String userId;
    private List<QuizDto> quiz;

    @NoArgsConstructor
    @Getter
    public static class QuizDto {
        private String quiz;
        private int answer;
    }
}

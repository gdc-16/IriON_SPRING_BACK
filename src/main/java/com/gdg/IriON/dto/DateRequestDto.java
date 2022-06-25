package com.gdg.IriON.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class DateRequestDto {

    private Long userId;
    private Long animalId;
    private String content;

}

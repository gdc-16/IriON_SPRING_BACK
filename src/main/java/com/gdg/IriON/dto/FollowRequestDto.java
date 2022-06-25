package com.gdg.IriON.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FollowRequestDto {
    private Long userId;
    private Long animalId;
}

package com.gdg.IriON.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class FollowCancelRequestDto {
    private Long userId;
    private Long AnimalId;
}

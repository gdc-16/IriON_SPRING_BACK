package com.gdg.IriON.common;

import lombok.Builder;

@Builder
public class CommonResponse <T>{

    private T content;

    public static <T> CommonResponse<T> ok(T content) {
        return CommonResponse.<T>builder()
                .content(content)
                .build();
    }

    public static <T> CommonResponse<T> ok() {
        return CommonResponse.<T>builder()
                .content(null)
                .build();
    }

}

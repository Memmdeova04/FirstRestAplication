package com.example.FirstRestAplication.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import static com.example.FirstRestAplication.util.Constant.ERROR_MESSAGE;
import static com.example.FirstRestAplication.util.Constant.SUCCESS_MESSAGE;

@Builder
@Data
@AllArgsConstructor
public class API_RESPONSE<T> {
    String message;
    Boolean success;
    T data;

    public static <T> API_RESPONSE<T> success(T data) {
        return API_RESPONSE.<T>builder()
                .success(true)
                .message(SUCCESS_MESSAGE)
                .data(data)
                .build();
    }
    public static <T> API_RESPONSE<T> error(String message) {
        return API_RESPONSE.<T>builder()
                .success(false)
                .message(ERROR_MESSAGE)
                .data(null)
                .build();
    }

}


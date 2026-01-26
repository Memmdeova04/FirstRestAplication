package com.example.FirstRestAplication.exception;

import com.example.FirstRestAplication.dto.API_RESPONSE;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<API_RESPONSE<String>> handleException(UserNotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(API_RESPONSE.error(ex.getMessage()));
    }
    @ExceptionHandler
    public ResponseEntity<API_RESPONSE> handleMethodArgumentValidException
            (MethodArgumentNotValidException ex, Errors errors){
        HashMap<String, String> errorMap = new HashMap<>();
        errors.getFieldErrors().forEach((error)->{
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return  ResponseEntity
                .badRequest()
                .body(new API_RESPONSE<>("handle olunmus mesaj",false,errorMap));

    }
    @ExceptionHandler
    public ResponseEntity<API_RESPONSE>handleAccountActivityException(AccountActivityException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(API_RESPONSE.error(ex.getMessage()));
    }
    @ExceptionHandler
    public ResponseEntity<API_RESPONSE<String>> handleGeneralException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(API_RESPONSE.error("server has problem"+ ex.getMessage()));
    }

}
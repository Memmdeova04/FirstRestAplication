package com.example.FirstRestAplication.exception;

import static com.example.FirstRestAplication.util.Constant.USER_NOT_FOUND;



public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(final String message) {

        super(USER_NOT_FOUND);
    }
}
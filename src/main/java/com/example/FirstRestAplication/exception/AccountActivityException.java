package com.example.FirstRestAplication.exception;

import static com.example.FirstRestAplication.util.Constant.ACCOUNT_PROBLEM;
public class AccountActivityException extends RuntimeException {
    public AccountActivityException(String message) {

        super(ACCOUNT_PROBLEM);
    }
}
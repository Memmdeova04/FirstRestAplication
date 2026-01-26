package com.example.FirstRestAplication.controller;

import com.example.FirstRestAplication.dto.AccountReq;
import com.example.FirstRestAplication.dto.AccountRes;
import com.example.FirstRestAplication.dto.API_RESPONSE;
import com.example.FirstRestAplication.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    @PostMapping("/")
    public ResponseEntity<API_RESPONSE<AccountRes>> createAccount(
            @Valid @RequestBody AccountReq req) {
        return ResponseEntity.ok(API_RESPONSE.success(accountService.createAccount(req)));

    }

}
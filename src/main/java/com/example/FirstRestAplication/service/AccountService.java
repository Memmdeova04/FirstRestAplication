package com.example.FirstRestAplication.service;

import com.example.FirstRestAplication.dto.AccountReq;
import com.example.FirstRestAplication.dto.AccountRes;
import com.example.FirstRestAplication.dto.UserResponse;
import com.example.FirstRestAplication.entity.AccountEntity;
import com.example.FirstRestAplication.exception.AccountActivityException;
import com.example.FirstRestAplication.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final UserService userService;
    private static Map<Long, AccountEntity> accounts=new HashMap<>();
    private static Long generatedAccountId=0L;
    private final AccountMapper accountMapper;
    public AccountRes createAccount(AccountReq req) {

        UserResponse resp=userService.getUserById(req.getUserId());

        if(Boolean.FALSE.equals(resp.getActivityStatus())){
            throw new AccountActivityException("Account creation failed");
        }

        Long id=++generatedAccountId;
        AccountEntity entity=accountMapper.mapToEntity(req,id);
        accounts.put(id,entity);
        return accountMapper.mapToResponse(entity);

    }

}
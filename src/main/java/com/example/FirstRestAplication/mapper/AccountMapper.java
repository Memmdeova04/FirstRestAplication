package com.example.FirstRestAplication.mapper;

import com.example.FirstRestAplication.dto.AccountReq;
import com.example.FirstRestAplication.dto.AccountRes;
import com.example.FirstRestAplication.entity.AccountEntity;
import org.springframework.stereotype.Component;
@Component
public class AccountMapper {
    public AccountEntity mapToEntity(AccountReq req, Long id) {
        return AccountEntity.builder()
                .id(id)
                .userId(req.getUserId())
                .cardNumber(req.getCreditCardNumber())
                .cvv(req.getCvv())
                .cardExpiryDate(req.getCardExpiryDate())
                .accountNumber(req.getAccountNumber())
                .currency(req.getCurrency())
                .build();
    }
    public AccountRes mapToResponse(AccountEntity entity) {
        return AccountRes.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .accountNumber(entity.getAccountNumber())
                .cardNumber(entity.getCardNumber())
                .cardExpiryDate(entity.getCardExpiryDate())
                .currency(entity.getCurrency())
                .build();
    }
}
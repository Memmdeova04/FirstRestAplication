package com.example.FirstRestAplication.entity;

import com.example.FirstRestAplication.util.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {
    private String accountNumber;
    private String cardNumber;
    private Currency currency;
    private Long id;
    private String cvv;
    private LocalDate cardExpiryDate;
    private Long userId;
}
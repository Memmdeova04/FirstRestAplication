package com.example.FirstRestAplication.dto;

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
public class AccountRes {
    private Long id;
    private Long userId;
    private String accountNumber;
    private String cardNumber;
    private LocalDate cardExpiryDate;
    private Currency currency;
}
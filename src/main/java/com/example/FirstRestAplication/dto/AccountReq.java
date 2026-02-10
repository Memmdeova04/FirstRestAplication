package com.example.FirstRestAplication.dto;

import com.example.FirstRestAplication.util.Currency;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
public class AccountReq {
    @NotNull
    Long userId;
    @NotBlank
    @Pattern(regexp ="^\\d{16}$")
    String creditCardNumber;
    @NotBlank
    @Pattern(regexp = "^\\d{3}$")
    String cvv;
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate cardExpiryDate;
    @NotNull
    @Size(min = 20, max = 20)
    String accountNumber;
    @NotNull
    Currency currency;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9]{7}$")
    private String finCode;

}
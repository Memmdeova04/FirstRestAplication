package com.example.FirstRestAplication.dto;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserRequest {
    @NotBlank
    @Size(min = 2, max = 100)
    private String name;
    @NotBlank
    @Size(min = 2, max = 100)
    private String surname;
    @NotNull
    @Min(18)
    private Integer age;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(min = 8, max = 64)
    private String password;
    @NotBlank
    @Pattern(regexp = "^[A-Za-z0-9]{7}$")
    private String finCode;

}

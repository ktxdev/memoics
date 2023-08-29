package com.ktxdev.memoics.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserDto {
    @NotBlank(message = "Full name should be provided")
    String fullName;
    @NotBlank(message = "Username should be provided")
    String username;
    @NotBlank(message = "Password should be provided")
    String password;
    @NotBlank(message = "Confirmation password should be provided")
    String passwordConfirm;
}

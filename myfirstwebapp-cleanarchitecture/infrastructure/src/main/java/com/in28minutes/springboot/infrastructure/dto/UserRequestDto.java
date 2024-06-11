package com.in28minutes.springboot.infrastructure.dto;

import java.util.UUID;

import com.in28minutes.springboot.core.domain.enums.UserTypeEnum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    private UUID id;

    @NotNull
    private UserTypeEnum type;

    @NotBlank
    private String login;

    @NotBlank
    private String password;
    
}

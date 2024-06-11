package com.in28minutes.springboot.infrastructure.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.in28minutes.springboot.core.domain.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoRequestDto {
    
    private UUID id;

    @NotNull
    private User user;

    @NotBlank
    private String description;

    @NotNull
    private LocalDate targetDate;

    @NotNull
    private Boolean done;
    
}

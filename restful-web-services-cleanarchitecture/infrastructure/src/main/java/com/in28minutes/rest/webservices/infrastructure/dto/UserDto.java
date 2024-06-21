package com.in28minutes.rest.webservices.infrastructure.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.in28minutes.rest.webservices.core.domain.Post;
import com.in28minutes.rest.webservices.core.domain.enums.UserType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private UUID id;

    @NotBlank(message = "o campo deve ser informado")
    private String name;

    @NotNull(message = "o campo deve ser informado")
    private LocalDate birthDate;

    @NotNull(message = "o campo deve ser informado")
    private UserType userType;

    private List<Post> posts;
    
}

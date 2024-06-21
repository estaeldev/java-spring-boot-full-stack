package com.in28minutes.rest.webservices.infrastructure.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    
    private UUID id;

    @NotBlank(message = "o campo deve ser informado")
    private String description;
    
}

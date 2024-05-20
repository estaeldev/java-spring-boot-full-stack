package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    private int id;

    private String username;

    @Size(min = 10, message = "Enter atleast 10 characters")
    private String description;

    private LocalDate targetDate;

    private Boolean done;
    
}

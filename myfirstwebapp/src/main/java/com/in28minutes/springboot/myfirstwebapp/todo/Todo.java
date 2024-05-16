package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    private int id;
    private String username;
    private String description;
    private LocalDate targetDate;
    private Boolean done;
    
}

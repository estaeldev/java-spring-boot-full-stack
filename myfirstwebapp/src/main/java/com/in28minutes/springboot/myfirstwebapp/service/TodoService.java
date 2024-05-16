package com.in28minutes.springboot.myfirstwebapp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.in28minutes.springboot.myfirstwebapp.todo.Todo;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    static {
        String username = "in28minutes";
        todos.add(new Todo(1, username, "Learn AWS", 
            LocalDate.now().plusYears(1), Boolean.FALSE));

        todos.add(new Todo(2, username, "Learn DevOps", 
            LocalDate.now().plusYears(2), Boolean.FALSE));

        todos.add(new Todo(3, username, "Learn Full Stack Development", 
            LocalDate.now().plusYears(3), Boolean.FALSE));
    }

    public List<Todo> getTodos() {
        return todos;
    }
    

}

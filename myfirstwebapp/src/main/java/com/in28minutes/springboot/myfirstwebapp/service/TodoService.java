package com.in28minutes.springboot.myfirstwebapp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.in28minutes.springboot.myfirstwebapp.todo.Todo;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();
    private static int todoCount = 0;

    static {
        String username = "in28minutes";
        todos.add(new Todo(++todoCount, username, "Learn AWS", 
            LocalDate.now().plusYears(1), Boolean.FALSE));

        todos.add(new Todo(++todoCount, username, "Learn DevOps", 
            LocalDate.now().plusYears(2), Boolean.FALSE));

        todos.add(new Todo(++todoCount, username, "Learn Full Stack Development", 
            LocalDate.now().plusYears(3), Boolean.FALSE));
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void addTodo(Todo todo) {
        todo.setId(++todoCount);
        todos.add(todo);
    }
    

}

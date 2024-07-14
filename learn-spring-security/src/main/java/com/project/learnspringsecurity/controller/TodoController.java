package com.project.learnspringsecurity.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private static final List<Todo> TODOS_LIST = new ArrayList<>();

    static {
        TODOS_LIST.addAll(List.of(
            new Todo(1, "estael", "Learn AWS"),
            new Todo(2, "estael", "Get AWS Certified")
        ));
    }
    
    @GetMapping
    public List<Todo> findAll() {
        return TODOS_LIST;
    }

    @GetMapping("users/{username}")
    public List<Todo> findAllByUsername(@PathVariable final String username) {
        return TODOS_LIST.stream().filter(todo -> Objects.equals(todo.getUsername(), username)).toList();
    }

    @GetMapping("users/{username}/{id}")
    public Todo findByIdByUsername(@PathVariable final String username, @PathVariable final Integer id) {
        List<Todo> listTodo = TODOS_LIST.stream().filter(todo -> Objects.equals(todo.getUsername(), username)).toList();
        return listTodo.stream().filter(todo -> Objects.equals(todo.getId(), id)).findFirst().orElse(null);
    }

    @PostMapping
    public Todo create(@RequestBody final Todo todo) {
        int totalTodos = TODOS_LIST.size();
        if(Objects.nonNull(todo.getId())) {
            return null;
        }
        todo.setId(++totalTodos);
        TODOS_LIST.add(todo);
        return todo;
    }


}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Todo {

    Integer id;
    String username;
    String description;

}
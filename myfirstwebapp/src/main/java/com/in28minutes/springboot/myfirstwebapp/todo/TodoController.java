package com.in28minutes.springboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.springboot.myfirstwebapp.service.TodoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@SessionAttributes("name")
public class TodoController {

    private final TodoService todoService;
    
    @GetMapping("/list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = this.todoService.getTodos();
        model.addAttribute("todos", todos);
        return "listTodos";
    }


}

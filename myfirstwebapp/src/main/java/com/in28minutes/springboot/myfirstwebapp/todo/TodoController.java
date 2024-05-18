package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/add-todo")
    public String showNewTodoPage(ModelMap model) {
        String username = (String) model.get("name");
        Todo todo = new Todo(0, username, "", LocalDate.now(), Boolean.FALSE);
        model.put("todo", todo);
        return "todo";
    }

    @PostMapping("/add-todo")
    public String addTodoPage(Todo todo, ModelMap model) {
        String username = (String) model.get("name");
        Todo todoSaved = new Todo(0, username, todo.getDescription(), LocalDate.now().plusYears(1), Boolean.FALSE);
        this.todoService.addTodo(todoSaved);
        return "redirect:list-todos";
    }


}

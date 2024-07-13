package com.in28minutes.rest.webservices.restfulwebservices.todo;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoJpaService {
	
	private final TodoRepository todoRepository;
	
	public List<Todo> findByUsername(String username){
		return this.todoRepository.findByUsername(username);
	}
	
	public void deleteById(Integer id) {
		this.todoRepository.deleteById(id);
	}
	
	public Todo findById(Integer id) {
		Optional<Todo> todoOpt = this.todoRepository.findById(id);
		return todoOpt.orElse(null);
	}

	public Todo updateTodo(String username, Integer id, Todo todo) {
		Todo findTodo = findById(id);

		if(Objects.isNull(findTodo)) {
			return null;
		}

		todo.setId(id);
		todo.setUsername(username);
		return this.todoRepository.save(todo);
	}

	public Todo createTodo(Todo todo) {

		if(Objects.nonNull(todo.getId())) {
			return null;
		}

		return this.todoRepository.save(todo);
	}


}

package com.victorgarciar.todo.controllers;

import com.victorgarciar.todo.controllers.api.TodoApi;
import com.victorgarciar.todo.dto.TodoDto;
import com.victorgarciar.todo.services.CategoryService;
import com.victorgarciar.todo.services.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TodoController implements TodoApi {

    private final TodoService todoService;

    private final CategoryService categoryService;

    public TodoController(TodoService todoService, CategoryService categoryService) {
        this.todoService = todoService;
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<TodoDto> createTodo(TodoDto userDto) {
        return new ResponseEntity<>(todoService.save(userDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<TodoDto> updateTodo(TodoDto todoDto) {
        return new ResponseEntity<>(todoService.save(todoDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        return new ResponseEntity<>(todoService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<TodoDto> getTodo(Long todoId) {
        return  new ResponseEntity<>(todoService.findById(todoId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteTodo(Long id) {
        return null;
    }
}

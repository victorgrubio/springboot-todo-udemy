package com.victorgarciar.todo.controllers;

import com.victorgarciar.todo.controllers.api.CategoryApi;
import com.victorgarciar.todo.dto.CategoryDto;
import com.victorgarciar.todo.dto.TodoDto;
import com.victorgarciar.todo.services.CategoryService;
import com.victorgarciar.todo.services.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("rawtypes")
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoryController implements CategoryApi {

    private final TodoService todoService;

    private final CategoryService categoryService;

    public CategoryController(TodoService todoService, CategoryService categoryService) {
        this.todoService = todoService;
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<CategoryDto> createCategory(CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.save(categoryDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CategoryDto> updateCategory(Long id, CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.save(categoryDto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TodoDto>> getAllTodoByCategoriesId(Long id) {
        return new ResponseEntity<>(todoService.findByCategory(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<CategoryDto>> getAllCategoriesByUserId(Long userId) {
        return new ResponseEntity<>(categoryService.findAllByUserId(userId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoryDto> getCategory(Long id) {
        return new ResponseEntity<>(categoryService.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteCategory(Long id) {
        categoryService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<TodoDto>> getAllTodoByCategoriesForToday(Long userId) {
        return new ResponseEntity(categoryService.getAllTodoByCategoriesForToday(userId), HttpStatus.OK);
    }
}

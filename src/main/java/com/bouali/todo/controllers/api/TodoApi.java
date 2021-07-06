package com.bouali.todo.controllers.api;

import com.bouali.todo.dto.TodoDto;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Api( "/todos")
public interface TodoApi {

    /**
     * POST /todos - Create new to-do item
     * @param todoDto the to-do task data
     * @return The created to-do task
     */
    @PostMapping(
            value =  "/todos",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiOperation(value = "Create To do", notes = "Creates a new to do ", response = TodoDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The newly created To do.")
    })
    ResponseEntity<TodoDto> createTodo(
            @ApiParam(value = "Todo DTO", required = true)
            @RequestBody TodoDto todoDto
    );

    /**
     * PATCH /todos - Update an existing to-do entity
     * @param todoTask The task that will be updated
     * @return The task updated
     */
    @PatchMapping(
            value =  "/todos",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiOperation(value = "Update Todo", notes = "Updates an existing Todo ", response = TodoDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The newly created Todo.")
    })
    ResponseEntity<TodoDto> updateTodo(
            @ApiParam(value = "Todo DTO", required = true)
            @RequestBody TodoDto todoTask
    );

    /**
     * GET /todos - List all todos available
     * @return List of TodoDTO
     */
    @GetMapping(value =  "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Todo Details", notes = "Returns the list of the Todos", responseContainer = "List<TodoDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of the Todos"),
    })
    ResponseEntity<List<TodoDto>> getAllTodos();

    /**
     * Get a to-do task by id
     * @param todoId Id of task to get
     * @return The todoTask requested
     */
    @GetMapping(value =  "/todos/{todoId:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Todo Details", notes = "Returns the Todo", response = TodoDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Todo"),
            @ApiResponse(code = 404, message = "Todo not found")
    })
    ResponseEntity<TodoDto> getTodo(
            @ApiParam(value = "The Todo id", required = true)
            @PathVariable Long todoId
    );

    /**
     * DELETE /todos/id - Delete a task
     * @param id Id of the task
     * @return Response entity for the task that will be deleted
     */
    @DeleteMapping(value =  "/todos/{id:.+}")
    @ApiOperation(value = "Delete Todo", notes = "Deletes a Todo by ID", response = TodoDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Todo deleted"),
            @ApiResponse(code = 404, message = "Todo not found")
    })
    ResponseEntity<?> deleteTodo(
            @ApiParam(value = "The Todo id", required = true) @PathVariable Long id
    );
}

package com.victorgarciar.todo.controllers.api;

import com.victorgarciar.todo.dto.TodoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@Tag(name="todos")
public interface TodoApi {

    /**
     * POST /todos - Create new to-do item
     * @param todoDto the to-do task data
     * @return The created to-do task
     */
    @PostMapping(
             value = "/todos",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Create To do", description = "Creates a new to do ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The newly created To do.")
    })
    ResponseEntity<TodoDto> createTodo(
            @Parameter(name = "Todo DTO", required = true)
            @RequestBody TodoDto todoDto
    );

    /**
     * PATCH /todos - Update an existing to-do entity
     * @param todoTask The task that will be updated
     * @return The task updated
     */
    @PatchMapping(
            value =  "/todos/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Update Todo", description = "Updates an existing Todo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The newly created Todo.")
    })
    ResponseEntity<TodoDto> updateTodo(
            @Parameter(name = "id", description = "The Todo Id", required = true)
            @PathVariable Long id,
            @Parameter(name = "Todo DTO", required = true)
            @RequestBody TodoDto todoTask
    );

    /**
     * GET /todos - List all todos available
     * @return List of TodoDTO
     */
    @GetMapping(value =  "/todos", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Todo Details", description = "Returns the list of the Todos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of the Todos"),
    })
    ResponseEntity<List<TodoDto>> getAllTodos();

    /**
     * Get a to-do task by id
     * @param id Id of task to get
     * @return The todoTask requested
     */
    @GetMapping(value =  "/todos/{id:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Todo Details", description = "Returns the Todo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Todo"),
            @ApiResponse(responseCode = "404", description = "Todo not found")
    })
    ResponseEntity<TodoDto> getTodo(
            @Parameter(name = "id", description = "The Todo Id", required = true)
            @PathVariable Long id
    );

    /**
     * DELETE /todos/id - Delete a task
     * @param id Id of the task
     * @return Response entity for the task that will be deleted
     */
    @DeleteMapping(value =  "/todos/{id:.+}")
    @Operation(summary = "Delete Todo", description = "Deletes a Todo by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Todo deleted"),
            @ApiResponse(responseCode = "404", description = "Todo not found")
    })
    ResponseEntity<?> deleteTodo(
            @Parameter(name="id", description = "The Todo id", required = true) @PathVariable Long id
    );
}

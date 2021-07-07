package com.victorgarciar.todo.controllers.api;

import com.victorgarciar.todo.dto.CategoryDto;
import com.victorgarciar.todo.dto.TodoDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@Tag(name="/categories")
public interface CategoryApi {

    /**
     * POST /categories - Create a new category
     * @param categoryDto DTO with the category data
     * @return The created Category
     */
    @PostMapping(
            value =  "/categories",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            value = "Create category",
            notes = "Creates a new category ",
            response = CategoryDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = 201, description = "The newly created Category.")
    })
    ResponseEntity<CategoryDto> createCategory(
            @Parameter(value = "Category DTO", required = true) @RequestBody CategoryDto categoryDto
    );

    /**
     * PATCH /categories - updates an existing category
     * @param user Category update body
     * @return ResponseEntity<CategoryDto> The Category DTO containing the response data
     */
    @PatchMapping(
            value =  "/categories",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            value = "Update Category",
            notes = "Updates an existing Category ",
            response = CategoryDto.class
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = 201, description = "The newly created user.")
    })
    ResponseEntity<CategoryDto> updateCategory(
            @Parameter(value = "Category DTO", required = true) @RequestBody CategoryDto user
    );

    /**
     * GET /categories - Returns a list of categories
     * @return  List of categories
     */
    @GetMapping(
            value =  "/categories",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            value = "Category Details",
            notes = "Returns the list of the categories",
            responseContainer = "List<CategoryDto>"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = 200, description = "List of the categories"),
    })
    ResponseEntity<List<CategoryDto>> getAllCategories();

    /**
     * GET /categories/todos/id - Get a category of todos
     * @param id The category id
     * @return List(TodoDTO) List of To-do tasks of the category
     */
    @GetMapping(
            value =  "/categories/todos/{id:.+}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            value = "Todo Details by category ID",
            notes = "Returns the list of the Todo of a selected category",
            responseContainer = "List<TodoDto>"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = 200, description = "List of the Todos"),
    })
    ResponseEntity<List<TodoDto>> getAllTodoByCategoriesId(
            @Parameter(value = "Category ID", required = true)
            @PathParam(value = "id") @PathVariable Long id
    );

    /**
     * GET /categories/todos/today/userId - Get all categories for today
     * @param userId Id of user to get data
     * @return The list of to-do associated with the day
     */
    @GetMapping(
            value =  "/categories/todos/today/{userId:.+}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            value = "List of all categories and Todo for today",
            notes = "Returns the list of the Todo of a selected category",
            responseContainer = "List<CategoryDto>"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = 200, description = "List of the Todos"),
    })
    ResponseEntity<List<TodoDto>> getAllTodoByCategoriesForToday(
            @Parameter(value = "User ID", required = true)
            @PathParam(value = "userId") @PathVariable Long userId
    );

    /**
     * GET /categories/user/{id}
     * Get categories of a concrete user
     * @param id Id of the user
     * @return List of categories DTO asociated with the user
     */
    @GetMapping(
            value =  "/categories/users/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            value = "Category Details by user ID",
            notes = "Returns the list of the categories of a selected user", responseContainer = "List<CategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(responseCode = 200, description = "List of the categories"),
    })
    ResponseEntity<List<CategoryDto>> getAllCategoriesByUserId(
            @Parameter(value = "User ID", required = true)
            @PathParam(value = "id") @PathVariable Long id
    );

    /**
     * GET /categories/{}
     * Get a concrete category by id
     * @param id Id of category
     * @return The category requested
     */
    @GetMapping(
            value = "/categories/{id:.+}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(value = "Category Details", notes = "Returns the list of the users", response = CategoryDto.class)
    @ApiResponses(value = {
            @ApiResponse(responseCode = 200, description = "The Category"),
            @ApiResponse(responseCode = 404, description = "Category not found")
    })
    ResponseEntity<CategoryDto> getCategory(
            @Parameter(value = "The category id", required = true)
            @PathParam(value = "id") @PathVariable Long id
    );

    /**
     * DELETE /categories/id
     * @param id Id of category to be deleted
     * @return Response entity
     */
    @DeleteMapping(value =  "/categories/{id:.+}")
    @Operation(value = "Delete category", notes = "Deletes a category by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The category deleted"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    ResponseEntity<?> deleteCategory(
            @Parameter(value = "The category id", required = true)
            @PathVariable Long id
    );
}

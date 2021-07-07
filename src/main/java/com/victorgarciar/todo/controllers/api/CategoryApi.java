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


@Tag(name="categories")
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
            summary = "Create category",
            description = "Creates a new category "
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The newly created Category.")
    })
    ResponseEntity<CategoryDto> createCategory(
            @Parameter(name = "Category DTO", required = true) @RequestBody CategoryDto categoryDto
    );

    /**
     * PATCH /categories - updates an existing category
     * @param user Category update body
     * @param id The category id
     * @return ResponseEntity<CategoryDto> The Category DTO containing the response data
     */
    @PatchMapping(
            value =  "/categories/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Update Category",
            description = "Updates an existing Category "
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The newly created user.")
    })
    ResponseEntity<CategoryDto> updateCategory(
            @Parameter(name = "id", description = "The Todo Id", required = true)
            @PathParam(value = "id") @PathVariable Long id,
            @Parameter(name = "Category DTO", required = true) @RequestBody CategoryDto user
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
            summary = "Category Details",
            description = "Returns the list of the categories"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of the categories"),
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
            summary = "Todo Details by category ID",
            description = "Returns the list of the Todo of a selected category"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of the Todos"),
    })
    ResponseEntity<List<TodoDto>> getAllTodoByCategoriesId(
            @Parameter(name = "Category ID", required = true) @PathParam(value = "id") @PathVariable Long id
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
            summary = "List of all categories and Todo for today",
            description = "Returns the list of the Todo of a selected category"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of the Todos"),
    })
    ResponseEntity<List<TodoDto>> getAllTodoByCategoriesForToday(
            @Parameter(name = "User ID", required = true)
            @PathParam(value = "userId") @PathVariable Long userId
    );

    /**
     * GET /categories/user/{id}
     * Get categories of a concrete user
     * @param userId Id of the user
     * @return List of categories DTO asociated with the user
     */
    @GetMapping(
            value =  "/categories/users/{userId:.+}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(
            summary = "Category Details by user ID",
            description = "Returns the list of the categories of a selected user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of the categories"),
    })
    ResponseEntity<List<CategoryDto>> getAllCategoriesByUserId(
            @Parameter(name = "User ID", required = true)
            @PathParam(value = "id") @PathVariable Long userId
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
    @Operation(summary = "Category Details", description = "Returns the list of the users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The Category"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    ResponseEntity<CategoryDto> getCategory(
            @Parameter(name = "The category id", required = true)
            @PathParam(value = "id") @PathVariable Long id
    );

    /**
     * DELETE /categories/id
     * @param id Id of category to be deleted
     * @return Response entity
     */
    @DeleteMapping(value =  "/categories/{id:.+}")
    @Operation(summary = "Delete category", description = "Deletes a category by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The category deleted"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    ResponseEntity<?> deleteCategory(
            @Parameter(name = "The category id", required = true)
            @PathVariable Long id
    );
}

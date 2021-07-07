package com.victorgarciar.todo.controllers.api;

import com.victorgarciar.todo.dto.UserDto;
;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="users")
public interface UserApi {

    /**
     * POST /users - Creates a new user
     * @param user UserDTO with the data of the user that will be created
     * @return the created user
     */
    @PostMapping(
            value =  "/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Create user", description = "Creates a new user ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The newly created user.")
    })
    ResponseEntity<UserDto> createUser(
            @Parameter(name = "User DTO", required = true)
            @RequestBody UserDto user
    );

    /**
     * PATCH /users/{id} - Updates user data
     * @param id Id of the user to be updated
     * @param user Content of the user that will be updated
     * @return The updated user
     */
    @PatchMapping(
            value =  "/users/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @Operation(summary = "Update user", description = "Updates an existing user ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The newly created user.")
    })
    ResponseEntity<UserDto> updateUser(
            @Parameter(name = "User ID", required = true) @PathVariable Long id,
            @Parameter(name = "User DTO", required = true) @RequestBody UserDto user);

    /**
     * GET /users - Get list of users
     * @return A list of UserDTO containing user information
     */
    @GetMapping(value =  "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "User Details", description = "Returns the list of the users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of the users"),
    })
    ResponseEntity<List<UserDto>> getAllUsers();

    /**
     * GET /user/id - Get the user info by id
     * @param id Identifier of the user
     * @return The UserDTO containing the user information
     */
    @GetMapping(value =  "/users/{id:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "User Details", description = "Returns the list of the users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The user"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    ResponseEntity<UserDto> getUser(
            @Parameter(name = "The use id", required = true) @PathVariable Long id
    );

    /**
     * DELETE /users/id - Delete a user by its id
     * @param id Id of the user that will be deleted
     * @return Response of the user delete method
     */
    @DeleteMapping(value =  "/users/{id:.+}")
    @Operation(summary = "Delete a user", description = "Deletes a user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The user"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    ResponseEntity deleteUser(
            @Parameter(name = "The use id", required = true) @PathVariable Long id
    );
}

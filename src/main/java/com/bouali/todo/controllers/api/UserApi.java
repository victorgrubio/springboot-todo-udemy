package com.bouali.todo.controllers.api;

import com.bouali.todo.dto.UserDto;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.bouali.todo.utils.Constants.APP_ROOT;

@Api(APP_ROOT + "/users")
public interface UserApi {

    /**
     * POST /users - Creates a new user
     * @param user UserDTO with the data of the user that will be created
     * @return the created user
     */
    @PostMapping(
            value = APP_ROOT + "/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiOperation(value = "Create user", notes = "Creates a new user ", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The newly created user.")
    })
    ResponseEntity<UserDto> createUser(
            @ApiParam(value = "User DTO", required = true)
            @RequestBody UserDto user
    );

    /**
     * PATCH /users/{id} - Updates user data
     * @param id Id of the user to be updated
     * @param user Content of the user that will be updated
     * @return The updated user
     */
    @PatchMapping(value = APP_ROOT + "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update user", notes = "Updates an existing user ", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The newly created user.")
    })
    ResponseEntity<UserDto> updateUser(
            @ApiParam(value = "User ID", required = true) @PathVariable Long id,
            @ApiParam(value = "User DTO", required = true) @RequestBody UserDto user);

    /**
     * GET /users - Get list of users
     * @return A list of UserDTO containing user information
     */
    @GetMapping(value = APP_ROOT + "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "User Details", notes = "Returns the list of the users", responseContainer = "List<UserDto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of the users"),
    })
    ResponseEntity<List<UserDto>> getAllUsers();

    /**
     * GET /user/id - Get the user info by id
     * @param id Identifier of the user
     * @return The UserDTO containing the user information
     */
    @GetMapping(value = APP_ROOT + "/users/{id:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "User Details", notes = "Returns the list of the users", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The user"),
            @ApiResponse(code = 404, message = "User not found")
    })
    ResponseEntity<UserDto> getUser(
            @ApiParam(value = "The use id", required = true) @PathVariable Long id
    );

    /**
     * DELETE /users/id - Delete a user by its id
     * @param id Id of the user that will be deleted
     * @return Response of the user delete method
     */
    @DeleteMapping(value = APP_ROOT + "/users/{id:.+}")
    @ApiOperation(value = "Delete a user", notes = "Deletes a user by ID", response = UserDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The user"),
            @ApiResponse(code = 404, message = "User not found")
    })
    ResponseEntity deleteUser(
            @ApiParam(value = "The use id", required = true) @PathVariable Long id
    );
}

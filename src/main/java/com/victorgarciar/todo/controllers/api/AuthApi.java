package com.victorgarciar.todo.controllers.api;

import com.victorgarciar.todo.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name="auth")
public interface AuthApi {


    /**
     * POST /auth/login - Logs the user in the application
     * @param user Dto for user login
     * @return a UserDTO for the logged user
     */
    @Operation(summary = "Login user", description = "Creates a new user ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The connected user.")
    })
    @PostMapping(
            value = "/auth/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<UserDto> loginUser(
            @Parameter(name = "User DTO", required = true)
            @RequestBody UserDto user
    );
}

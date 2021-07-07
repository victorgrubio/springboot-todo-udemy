package com.victorgarciar.todo.controllers;

import com.victorgarciar.todo.controllers.api.AuthApi;
import com.victorgarciar.todo.dto.UserDto;
import com.victorgarciar.todo.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthController implements AuthApi {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserDto> loginUser(UserDto user) {
        return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
    }
}

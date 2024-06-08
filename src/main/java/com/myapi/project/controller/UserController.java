package com.myapi.project.controller;

import com.myapi.project.dto.UserDto;
import com.myapi.project.model.UserModel;
import com.myapi.project.security.Token;
import com.myapi.project.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getUsers () {
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(204).build();
    }

    @PostMapping
    public ResponseEntity<UserModel> createUser(@Valid @RequestBody UserModel user){
        return ResponseEntity.status(201).body(userService.createUser(user));
    }

    @PutMapping
    public ResponseEntity<UserModel> updateUser(@Valid @RequestBody UserModel user){
        return ResponseEntity.status(200).body(userService.updateUser(user));
    }

    @PostMapping("/login")
    public ResponseEntity<Token> login(@Valid @RequestBody UserDto user){
        Token token = userService.generateToken(user);
        if(token != null) {
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(403).build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
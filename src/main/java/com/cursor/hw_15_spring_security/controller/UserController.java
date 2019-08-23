package com.cursor.hw_15_spring_security.controller;

import com.cursor.hw_15_spring_security.model.User;
import com.cursor.hw_15_spring_security.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/admin/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @GetMapping("/user/findById/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        User user = userService.getUserById(id).get();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }

    @GetMapping("/user/findByName/{userName}")
    public ResponseEntity<User> findUserByUserName(@PathVariable String userName) {
        User user = userService.findByUserName(userName).get();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }

    @GetMapping("/user/findByEmail/{email}")
    public ResponseEntity<User> findUserByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email).get();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }

    @DeleteMapping("/admin/deleteUserById/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") long userId) {
        userService.deleteById(userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @DeleteMapping("/admin/deleteUserByName/{userName}")
    public ResponseEntity deleteUserByUserName(@PathVariable("userName") String userName) {
        userService.deleteByUserName(userName);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @DeleteMapping("/admin/deleteUserByEmail/{email}")
    public ResponseEntity deleteUserByEmail(@PathVariable("email") String email) {
        userService.deleteByEmail(email);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}

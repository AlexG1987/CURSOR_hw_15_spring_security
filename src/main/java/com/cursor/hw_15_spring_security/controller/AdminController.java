package com.cursor.hw_15_spring_security.controller;

import com.cursor.hw_15_spring_security.model.User;
import com.cursor.hw_15_spring_security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin")
public class AdminController {

    private final UserService userService;

    @PostMapping("/")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") long userId) {
        userService.deleteById(userId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @DeleteMapping("/username/{userName}")
    public ResponseEntity deleteUserByUserName(@PathVariable("userName") String userName) {
        userService.deleteByUserName(userName);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @DeleteMapping("/email/{email}")
    public ResponseEntity deleteUserByEmail(@PathVariable("email") String email) {
        userService.deleteByEmail(email);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

}

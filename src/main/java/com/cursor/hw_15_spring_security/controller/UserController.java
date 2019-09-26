package com.cursor.hw_15_spring_security.controller;

import com.cursor.hw_15_spring_security.model.User;
import com.cursor.hw_15_spring_security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @GetMapping("/id/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) {
        User user = userService.getUserById(id).get();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }

    @GetMapping("/username/{userName}")
    public ResponseEntity<User> findUserByUserName(@PathVariable String userName) {
        User user = userService.findByUserName(userName).get();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> findUserByEmail(@PathVariable String email) {
        User user = userService.findByEmail(email).get();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }

}

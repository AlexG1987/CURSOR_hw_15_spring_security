package com.cursor.hw_15_spring_security.service;

import com.cursor.hw_15_spring_security.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(Long id);

    Optional<User> findByUserName(String userName);

    Optional<User> findByEmail(String email);

    boolean existsByUserName(String userName);

    void deleteByUserName(String userName);

    void deleteByEmail(String email);

    void deleteById(Long id);

    void saveUser(User user);

}

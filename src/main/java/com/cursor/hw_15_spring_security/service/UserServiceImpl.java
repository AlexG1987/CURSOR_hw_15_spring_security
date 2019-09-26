package com.cursor.hw_15_spring_security.service;

import com.cursor.hw_15_spring_security.model.User;
import com.cursor.hw_15_spring_security.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        if (userRepository.getUserById(id).isPresent()) {
            return userRepository.getUserById(id);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        if (userRepository.findByUserName(userName).isPresent()) {
            return userRepository.findByUserName(userName);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            return userRepository.findByEmail(email);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean existsByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }

    @Override
    public void deleteByUserName(String userName) {
        userRepository.deleteByUserName(userName);
    }

    @Override
    public void deleteByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if (userRepository.findByUserName(userName).isPresent()) {
            return userRepository.findByUserName(userName).get();
        } else {
            throw new UsernameNotFoundException("User not found!");
        }
    }
}

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
        return userRepository.getUserById(id).isPresent() ? userRepository.getUserById(id) : Optional.empty();
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName).isPresent() ? userRepository.findByUserName(userName) : Optional.empty();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email).isPresent() ? userRepository.findByEmail(email) : Optional.empty();
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
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUserName(s).get();
    }
}

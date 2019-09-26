package com.cursor.hw_15_spring_security.repo;

import com.cursor.hw_15_spring_security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> getUserById(Long id);

    Optional<User> findByUserName(String userName);

    Optional<User> findByEmail(String email);

    boolean existsByUserName(String userName);

    @Transactional
    void deleteByUserName(String userName);

    @Transactional
    void deleteByEmail(String email);

}

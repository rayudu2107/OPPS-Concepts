package com.training.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.book.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String username);
}

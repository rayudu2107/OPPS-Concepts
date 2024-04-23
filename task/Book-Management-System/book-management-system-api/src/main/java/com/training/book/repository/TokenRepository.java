package com.training.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.book.entity.Token;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    Optional<Token> findByToken(String token);
}

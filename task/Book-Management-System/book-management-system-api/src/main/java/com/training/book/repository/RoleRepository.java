package com.training.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.book.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String roleStudent);
}

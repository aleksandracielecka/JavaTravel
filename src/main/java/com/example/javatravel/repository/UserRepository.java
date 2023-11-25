package com.example.javatravel.repository;

import java.util.Optional;

import com.example.javatravel.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
   Optional<UserEntity> findByEmail(String email);

}

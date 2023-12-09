package com.example.javatravel.repository;

import com.example.javatravel.entity.StandardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StandardRepository extends JpaRepository<StandardEntity, String> {
}

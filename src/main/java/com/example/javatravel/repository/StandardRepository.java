package com.example.javatravel.repository;

import com.example.javatravel.entity.StandardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StandardRepository extends JpaRepository<StandardEntity, String> {
    StandardEntity findByStandardType(StandardEntity.StandardType standardType);


}

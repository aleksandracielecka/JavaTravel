package com.example.javatravel.repository;

import com.example.javatravel.entity.TripEntity;
import com.example.javatravel.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TripRepository extends JpaRepository <TripEntity, Long> {


}

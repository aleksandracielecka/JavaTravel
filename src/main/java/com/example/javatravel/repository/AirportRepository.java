package com.example.javatravel.repository;

import com.example.javatravel.entity.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<AirportEntity,String> {


    AirportEntity getByCode(String code);
}

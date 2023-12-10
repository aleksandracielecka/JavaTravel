package com.example.javatravel.repository;

import com.example.javatravel.entity.LocationEntity;
import com.example.javatravel.entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

}

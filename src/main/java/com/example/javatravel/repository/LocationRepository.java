package com.example.javatravel.repository;

import com.example.javatravel.entity.LocationEntity;
import com.example.javatravel.entity.TripEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
//    List<LocationEntity> findAll(String color);
//
//    @Query("SELECT c FROM CarModel c WHERE LOWER(c.color) =LOWER(:colorParam)")
//    List<CarModel> listCarsByColor(@Param("colorParam") String colorParam);
}

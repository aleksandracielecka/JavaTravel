package com.example.javatravel.repository;

import com.example.javatravel.entity.TripEntity;
import com.example.javatravel.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository

public interface TripRepository extends JpaRepository <TripEntity, Long> {


    @Query("select trip from TripEntity trip where (trip.startDate between :startDate and :endDate) and (" +
            "trip.endDate between :startDate and :endDate) and trip.airportTo.location.id in (:locations)")
    List<TripEntity> listTripsByStartDateAndEndDate(LocalDate startDate, LocalDate endDate, List<Long> locations);

}

package com.example.javatravel.service;

import com.example.javatravel.dto.TripDto;
import com.example.javatravel.entity.TripEntity;
import com.example.javatravel.repository.TripRepository;
import com.example.javatravel.utils.mapper.TripMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TripService {
    private final TripRepository tripRepository;
    // metody delete update create read
    public List<TripEntity> getTripList() {
        return tripRepository.findAll();
    }

    public TripEntity editTrip(TripEntity trip) {
        return tripRepository.save(trip);
    }

    public void deleteTrip(Long id) {
        if(!tripRepository.existsById(id)){
            throw new EntityNotFoundException("Trip not found" + id);
        }
        tripRepository.deleteById(id);
    }

    public TripDto addTrip(TripDto tripDto) {
        //toDo
        //validate()
        //tripValidationException extens RuntimeException
        //"nieprawidłowe daty.. sprawdź..."
        TripEntity tripEntity = TripMapper.toTripEntity(tripDto);
        TripEntity addTrip = tripRepository.save(tripEntity);

        return TripMapper.toTripDto(addTrip);
    }

    public List<TripEntity> tripFilter(List<Long> selectedLocations, LocalDate startDate, LocalDate endDate) {
        List<TripEntity> allTrips = tripRepository.findAll();
        List<TripEntity> filterTrips = new ArrayList<>();
        for(TripEntity trip: allTrips){
            if (selectedLocations.contains(trip.getAirportTo().getLocation().getId())){
                LocalDate tripStartDate = trip.getStartDate();
                LocalDate tripEndDate = trip.getEndDate();
                if((startDate == null || tripStartDate.isEqual(startDate) || tripStartDate.isAfter(startDate) &&
                        (endDate == null || tripEndDate.isEqual(endDate) || tripEndDate.isAfter(endDate)))){
                    filterTrips.add(trip);

                }
            }
        }
       return filterTrips;
    }
    public TripEntity getTripById(Long id) {
        return tripRepository.findById(id).orElseThrow(()-> new RuntimeException("Nie znaleziono wycieczki"));
    }
}

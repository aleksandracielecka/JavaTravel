package com.example.javatravel.service;

import com.example.javatravel.dto.TripDto;
import com.example.javatravel.entity.TripEntity;
import com.example.javatravel.repository.TripRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
        return null;
    }
}

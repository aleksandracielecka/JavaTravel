package com.example.javatravel.service;

import com.example.javatravel.entity.LocationEntity;
import com.example.javatravel.repository.LocationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public List<LocationEntity> getLocationList(){

        return locationRepository.findAll();
    }
    public void  deleteLocation(Long id) {
        if(!locationRepository.existsById(id)){
            throw new EntityNotFoundException("Location not found" + id);
        }
        locationRepository.deleteById(id);
    }

    public LocationEntity updateLocation(LocationEntity location) {
        return locationRepository.save(location);
    }

//    public void addLocation(LocationEntity location){
//
//        locationRepository.save(location);
//    }
}

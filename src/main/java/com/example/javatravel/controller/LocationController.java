package com.example.javatravel.controller;

import com.example.javatravel.entity.LocationEntity;
import com.example.javatravel.service.LocationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping (value="/locations", produces = {MediaType.APPLICATION_JSON_VALUE})
public class LocationController {
    private final LocationService locationService;
    @GetMapping
    public ResponseEntity<List<LocationEntity>> getLocationList() {

        try {
            List<LocationEntity> locations = locationService.getLocationList();
            return ResponseEntity.ok(locations);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<LocationEntity> updateLocation(@RequestBody LocationEntity location) {
        try {
            LocationEntity updateLocation = locationService.updateLocation(location);
            return ResponseEntity.ok(updateLocation);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Long id) {
        try {
            locationService.deleteLocation(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();


        }
    }
}

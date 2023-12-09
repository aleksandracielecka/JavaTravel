package com.example.javatravel.controller;

import com.example.javatravel.dto.TripDto;
import com.example.javatravel.entity.TripEntity;
import com.example.javatravel.service.TripService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/trips", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TripController {

    private final TripService tripService;

    @GetMapping
    public ResponseEntity<List<TripEntity>> getTripList() {
        try {
            List<TripEntity> trips = tripService.getTripList();
            return ResponseEntity.ok(trips);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<TripDto> addTrip(@RequestBody TripDto tripDto){
        try {
            TripDto addTrip = tripService.addTrip(tripDto);
            return ResponseEntity.ok(addTrip);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<TripEntity> editTrip(@RequestBody TripEntity trip) {
        try {
            TripEntity updateTrip = tripService.editTrip(trip);
            return ResponseEntity.ok(updateTrip);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Long id){
        try {
            tripService.deleteTrip(id);
            return ResponseEntity.noContent().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }

    }






}

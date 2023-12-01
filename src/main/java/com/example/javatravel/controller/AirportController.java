package com.example.javatravel.controller;

import com.example.javatravel.dto.AirportDto;
import com.example.javatravel.entity.AirportEntity;
import com.example.javatravel.service.AirportService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/airports", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class AirportController {

    private final AirportService airportService;

    @GetMapping
    public ResponseEntity<List<AirportEntity>> getAirportList() {
        try {
            List<AirportEntity> airports = airportService.getAirportList();
            return ResponseEntity.ok(airports);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<AirportDto> addAirport(@RequestBody AirportDto airportDto) {
        try {
            AirportDto addAirport = airportService.addAirport(airportDto);
            return ResponseEntity.ok(addAirport);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<AirportEntity> updateAirport(@RequestBody AirportEntity airport) {
        try {
            AirportEntity updateAirport = airportService.updateAirport(airport);
            return ResponseEntity.ok(updateAirport);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteAirport(@PathVariable String code) {
        try {
            airportService.deleteAirport(code);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }
}

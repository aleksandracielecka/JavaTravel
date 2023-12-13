package com.example.javatravel.controller.restController;


import com.example.javatravel.dto.HotelDto;
import com.example.javatravel.entity.HotelEntity;
import com.example.javatravel.service.HotelService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value ="/hotels", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @GetMapping
    public ResponseEntity<List<HotelEntity>> getHotelList(){
        try {
            List<HotelEntity> hotels = hotelService.getHotelList();
            return ResponseEntity.ok(hotels);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<HotelDto> addHotel(@RequestBody HotelDto hotelDto){
        try {
            HotelDto addAirport = hotelService.addHotel(hotelDto);
            return ResponseEntity.ok(addAirport);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<HotelEntity> updateHotel(@RequestBody HotelEntity hotel){
        try {
            HotelEntity updateAirport = hotelService.updateHotel(hotel);
            return ResponseEntity.ok(updateAirport);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id){
        try {
            hotelService.deleteHotel(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

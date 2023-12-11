package com.example.javatravel.controller;

import com.example.javatravel.dto.NewTripDto;
import com.example.javatravel.dto.TripDto;
import com.example.javatravel.entity.TripEntity;
import com.example.javatravel.service.TripService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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




    @PostMapping("/edit_trip")
    public String editTrip(@ModelAttribute("updatedTrip") NewTripDto updatedTrip, Model model) {
        try {
            TripDto dto = new TripDto();
            dto.setStartDate(updatedTrip.getStartDate());
            dto.setEndDate(updatedTrip.getEndDate());
            dto.setMaxAdultNumber(updatedTrip.getMaxAdultNumber());
            dto.setMaxChildNumber(updatedTrip.getMaxChildNumber());
            dto.setId(updatedTrip.getId());
            TripEntity updateTripEntity = tripService.editTrip(dto);
            log.info("TripEntity {} is updated", updateTripEntity);
            return "redirect:/main_page";
        } catch (Exception e) {
            log.error("Something went wrong", e);
            return "/errors";
        }
    }

    @GetMapping("/edit_trip/{id}")
    public String getEditTrip(@PathVariable("id") Long tripId, Model model) {
        // Pobieranie informacji o wycieczce do edycji na podstawie ID
        TripEntity trip = tripService.getTripById(tripId);
        log.info("Loaded trip details for trip id={}", tripId);
        NewTripDto tripDto = NewTripDto.builder()
                .startDate(trip.getStartDate())
                .endDate(trip.getEndDate())
                .maxAdultNumber(trip.getMaxAdultNumber())
                .maxChildNumber(trip.getMaxChildNumber())
                .id(trip.getId())
                .build();
        // Przekazanie wycieczki do formularza edycji w widoku
        model.addAttribute("trip", tripDto);

        // Zwrócenie widoku edycji
        return "editTrip";
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
    @GetMapping("/delete/{id}")
    public String deleteTripById(@PathVariable Long id) {
        try {
            tripService.deleteTrip(id);
            return "redirect:/main_page"; // Przekierowanie po usunięciu wycieczki
        } catch (EntityNotFoundException e) {

            // Obsłuż wyjątek, np. przekieruj do strony błędu
            return "error";
        }

    }






}

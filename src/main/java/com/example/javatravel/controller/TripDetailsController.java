package com.example.javatravel.controller;

import com.example.javatravel.entity.TripEntity;
import com.example.javatravel.service.TripService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class TripDetailsController {

    private TripService tripService;

    @GetMapping("/trip_details/{id}")
    public String getTripDetails(Model model, @PathVariable("id") Long tripId) {
        TripEntity trip = tripService.getTripById(tripId);
        model.addAttribute("trip", trip);
        return "tripDetails";
    }
}

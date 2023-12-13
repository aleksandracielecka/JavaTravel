package com.example.javatravel.controller;

import com.example.javatravel.dto.LocationDto;
import com.example.javatravel.entity.AirportEntity;
import com.example.javatravel.entity.HotelEntity;
import com.example.javatravel.entity.TripEntity;
import com.example.javatravel.service.AirportService;
import com.example.javatravel.service.HotelService;
import com.example.javatravel.service.LocationService;
import com.example.javatravel.service.TripService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@AllArgsConstructor
public class MainPageController {

    private final LocationService locationService;
    private final TripService tripService;

    @GetMapping("/main_page")
    public String getWelcome(Model model) {
        List<LocationDto> locations = locationService.getLocationList();
        model.addAttribute("locations", locations);
        List<TripEntity> trips = tripService.getTripList();
        model.addAttribute("trips", trips);

        return "mainPage";
    }


    @GetMapping("/filter_trips")
    public String getFilterTrips(@RequestParam(value = "location", required = false) List<Long> selectedLocations,
                                 @RequestParam(value = "startDate", required = false) LocalDate startDate,
                                 @RequestParam(value = "endDate", required = false) LocalDate endDate,
                                 Model model) {

        List<TripEntity> filterTrips = tripService.tripFilter(selectedLocations, startDate, endDate);

        model.addAttribute("filterTrips", filterTrips);
        return "trips";
    }
}

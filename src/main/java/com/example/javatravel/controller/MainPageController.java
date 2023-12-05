package com.example.javatravel.controller;

import com.example.javatravel.dto.LocationDto;
import com.example.javatravel.entity.AirportEntity;
import com.example.javatravel.entity.HotelEntity;
import com.example.javatravel.entity.TripEntity;
import com.example.javatravel.service.AirportService;
import com.example.javatravel.service.HotelService;
import com.example.javatravel.service.LocationService;
import com.example.javatravel.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainPageController {

    private LocationService locationService;
    private TripService tripService;

    @Autowired
    public MainPageController( LocationService locationService, TripService tripService) {

        this.locationService = locationService;
        this.tripService = tripService;
    }
    @GetMapping("/main_page")
    public String getWelcome(Model model) {
        List<LocationDto> locations = locationService.getLocationList();
        model.addAttribute("locations", locations);


        return "mainPage";
    }



    @GetMapping("/filter_trips")
    public String getFilterTrips(@RequestParam(value = "location", required = false) List<Long> selectedLocations,
                                         @RequestParam(value = "startDate", required = false) LocalDate startDate,
                                         @RequestParam(value = "endDate", required = false) LocalDate endDate,
                                         Model model) {
//        List<LocationDto> locations = locationService.getLocationList();
//        model.addAttribute("locations", locations);

        // Tutaj można użyć selectedLocations, startDate i endDate do filtrowania wycieczek z bazy danych
        List<TripEntity> filterTrips = tripService.tripFilter(selectedLocations, startDate, endDate);

        // Przekazanie wyników filtrowania do szablonu Thymeleaf
        model.addAttribute("filterTrips", filterTrips);
        return "mainPage"; // Zwrócenie widoku z wynikami filtrowania
    }


}

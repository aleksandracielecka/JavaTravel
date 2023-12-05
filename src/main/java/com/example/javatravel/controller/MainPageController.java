package com.example.javatravel.controller;

import com.example.javatravel.dto.LocationDto;
import com.example.javatravel.entity.AirportEntity;
import com.example.javatravel.entity.HotelEntity;
import com.example.javatravel.service.AirportService;
import com.example.javatravel.service.HotelService;
import com.example.javatravel.service.LocationService;
import com.example.javatravel.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainPageController {

    private LocationService locationService;

    @Autowired
    public MainPageController( LocationService locationService) {

        this.locationService = locationService;
    }
    @GetMapping("/main_page")
    public String getWelcome(Model model) {
        List<LocationDto> locations = locationService.getLocationList();
        model.addAttribute("locations", locations);


        return "mainPage";
    }


}

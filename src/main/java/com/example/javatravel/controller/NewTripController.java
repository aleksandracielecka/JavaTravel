package com.example.javatravel.controller;

import com.example.javatravel.dto.LocationDto;
import com.example.javatravel.dto.TripDto;
import com.example.javatravel.entity.AirportEntity;
import com.example.javatravel.entity.HotelEntity;
import com.example.javatravel.entity.LocationEntity;
import com.example.javatravel.entity.TripEntity;
import com.example.javatravel.repository.HotelRepository;
import com.example.javatravel.repository.LocationRepository;
import com.example.javatravel.repository.TripRepository;
import com.example.javatravel.service.AirportService;
import com.example.javatravel.service.HotelService;
import com.example.javatravel.service.LocationService;
import com.example.javatravel.service.TripService;
import com.example.javatravel.utils.mapper.TripMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.TextResourceOrigin;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class NewTripController {

    private TripService tripService;
    private HotelService hotelService;
    private LocationService locationService;
    private AirportService airportService;

    @Autowired
    public NewTripController(TripService tripService, HotelService hotelService, LocationService locationService, AirportService airportService) {
        this.tripService = tripService;
        this.hotelService = hotelService;
        this.locationService = locationService;
        this.airportService = airportService;
    }

    @GetMapping("/create_trip")
    public String getWelcome(Model model) {
        model.addAttribute("welcome", "Witaj adminie, wprowadź nową wycieczkę:");
        List<LocationDto> locations = locationService.getLocationList();
        model.addAttribute("locations", locations);
        List<HotelEntity> hotels = hotelService.getHotelList();
        model.addAttribute("hotels", hotels);
        List<AirportEntity> airports = airportService.getAirportList();
        model.addAttribute("airportsFrom", airports);
        model.addAttribute("airportsTo", airports);

        return "createTrip";
    }

    @PostMapping("/create_trip")
    public String createTrip(@RequestParam("selectedHotelId") Long selectedHotelId,
                             @RequestParam("airportCode") String code,
//                             @RequestParam("airportToCode") String codeTo,
                             @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                             @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                             @RequestParam("maxAdultNumber") Integer maxAdultNumber,
                             @RequestParam("maxChildNumber") Integer maxChildNumber) {

        HotelEntity selectedHotel = hotelService.getHotelById(selectedHotelId);
        AirportEntity selectedAirportFrom = airportService.getAirportCode(code);
        AirportEntity selectedAirportTo = airportService.getAirportCode(code);

        if (selectedHotel != null) {
            TripDto newTripDto = new TripDto();
            newTripDto.setHotel(selectedHotel);
            newTripDto.setAirportFrom(selectedAirportFrom);
            newTripDto.setAirportTo(selectedAirportTo);
            newTripDto.setStartDate(startDate);
            newTripDto.setEndDate(endDate);
            newTripDto.setMaxAdultNumber(maxAdultNumber);
            newTripDto.setMaxChildNumber(maxChildNumber);
            tripService.addTrip(newTripDto);
        }
        return "redirect:/create_trip";
    }

}

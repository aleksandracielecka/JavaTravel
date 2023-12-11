package com.example.javatravel.controller;

import com.example.javatravel.dto.LocationDto;
import com.example.javatravel.dto.NewTripDto;
import com.example.javatravel.dto.PurchaseDto;
import com.example.javatravel.dto.TripDto;
import com.example.javatravel.entity.*;
import com.example.javatravel.repository.*;
import com.example.javatravel.service.*;
import com.example.javatravel.utils.mapper.TripMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.TextResourceOrigin;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.DateUtils;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Controller
@AllArgsConstructor
@Slf4j
public class NewTripController {

    private final TripService tripService;

    private final HotelService hotelService;
    private final LocationService locationService;
    private final AirportService airportService;
    private final AirportRepository airportRepository;
    private final PriceService priceService;
    private final PriceRepository priceRepository;

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
        List<PriceEntity> prices = priceService.getPriceList();
        model.addAttribute("prices", prices);

        return "createTrip";
    }


    @PostMapping("/create_trip")
    public String createTrip(@ModelAttribute("newTrip") NewTripDto dto, Model model) {


         if (Objects.isNull(dto.getStartDate()) || dto.getStartDate().isBefore(LocalDate.now())){
                 model.addAttribute("error", "The id selected is out of Range, please select another id within range");
                 log.error("Incorrect startDate: {}", dto.getStartDate());
                 return "createTrip";
         }
        HotelEntity selectedHotel = hotelService.getHotelById(dto.getHotelId());
        AirportEntity selectedAirportFrom = airportRepository.getByCode(dto.getAirportFromCode());
        AirportEntity selectedAirportTo = airportRepository.getByCode(dto.getAirportToCode());
        PriceEntity selectedPrice = priceRepository.getPriceById(dto.getPriceId());


        TripDto newTripDto = new TripDto();
        newTripDto.setStartDate(dto.getStartDate());
        newTripDto.setEndDate(dto.getEndDate());
        newTripDto.setMaxAdultNumber(dto.getMaxAdultNumber());
        newTripDto.setMaxChildNumber(dto.getMaxChildNumber());
        newTripDto.setHotel(selectedHotel);
        newTripDto.setAirportFrom(selectedAirportFrom);
        newTripDto.setAirportTo(selectedAirportTo);
        newTripDto.setPrice(selectedPrice);
        tripService.addTrip(newTripDto);

        return "redirect:/create_trip";
    }

//    @PostMapping("/create_trip")
//    public String createTrip(@RequestParam("selectedHotelId") Long selectedHotelId,
//                             @RequestParam("airportCode") String code,
////                             @RequestParam("airportToCode") String codeTo,
//                             @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
//                             @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
//                             @RequestParam("maxAdultNumber") Integer maxAdultNumber,
//                             @RequestParam("maxChildNumber") Integer maxChildNumber) {
//
//        HotelEntity selectedHotel = hotelService.getHotelById(selectedHotelId);
//        AirportEntity selectedAirportFrom = airportService.getAirportCode(code);
//        AirportEntity selectedAirportTo = airportService.getAirportCode(code);
//
//        if (selectedHotel != null) {
//            TripDto newTripDto = new TripDto();
//            newTripDto.setHotel(selectedHotel);
//            newTripDto.setAirportFrom(selectedAirportFrom);
//            newTripDto.setAirportTo(selectedAirportTo);
//            newTripDto.setStartDate(startDate);
//            newTripDto.setEndDate(endDate);
//            newTripDto.setMaxAdultNumber(maxAdultNumber);
//            newTripDto.setMaxChildNumber(maxChildNumber);
//            tripService.addTrip(newTripDto);
//        }
//        return "redirect:/create_trip";
//    }

}

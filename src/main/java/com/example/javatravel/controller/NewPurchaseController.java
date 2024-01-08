package com.example.javatravel.controller;

import com.example.javatravel.dto.FinalPriceDto;
import com.example.javatravel.dto.PurchaseDto;
import com.example.javatravel.entity.TripEntity;
import com.example.javatravel.entity.enums.StandardType;
import com.example.javatravel.service.PurchaseService;
import com.example.javatravel.service.TripFinalPriceService;
import com.example.javatravel.service.TripService;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@AllArgsConstructor
public class NewPurchaseController {

    private TripFinalPriceService tripFinalPriceService;
    private PurchaseService purchaseService;
    private TripService tripService;


    @GetMapping("/purchase")
    public String getPurchase(@RequestParam("selectedTripId") Long selectedTripId, Model model) {
        TripEntity trip = tripService.getTripById(selectedTripId);
        model.addAttribute("selectedTrip", trip);
        model.addAttribute("standards", StandardType.values());
        return "purchase";
    }



    @PostMapping("/purchase")
    public String displayPrice(@ModelAttribute("finalPrice") FinalPriceDto dto,
                               Model model) {

        BigDecimal finalPrice = tripFinalPriceService.getFinalPrice(dto.getSelectedTripId(),
                dto.getAdultNumber(),
                dto.getChildNumber(),
                StandardType.valueOf(dto.getStandard()));
        model.addAttribute("finalPrice", finalPrice);
        model.addAttribute("selectedTrip", tripService.getTripById(dto.getSelectedTripId()));
        model.addAttribute("adultNumber", dto.getAdultNumber());
        model.addAttribute("childNumber", dto.getChildNumber());
        model.addAttribute("standard", dto.getStandard());

        return "finalPrice";
    }

    @GetMapping("/final_price")
    public String getPurchaseDetails(@RequestParam("selectedTripId") Long selectedTripId, Model model,
                                     @RequestParam("adultNumber") Integer adultNumber,
                                     @RequestParam("childNumber") Integer childNumber,
                                     @RequestParam("selectedStandard") StandardType selectedStandard,
                                     @RequestParam("finalPrice") BigDecimal finalPrice) {
        TripEntity trip = tripService.getTripById(selectedTripId);
        model.addAttribute("selectedTrip", trip);

        model.addAttribute("selectedStandard", StandardType.values());
        model.addAttribute("adultNumber", adultNumber);
        model.addAttribute("childNumber", childNumber);
        model.addAttribute("finalPrice", finalPrice);

        return "finalPrice";
    }


    @PostMapping("/final_price")
    public String createPurchase(@ModelAttribute("finalPurchase") PurchaseDto dto) {

        String email = ((User) SecurityContextHolder.getContext().
                getAuthentication().getPrincipal()).getUsername();

        purchaseService.createPurchase(dto, email);

        return "confirmation";
    }
}

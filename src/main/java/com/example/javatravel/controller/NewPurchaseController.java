package com.example.javatravel.controller;

import com.example.javatravel.dto.PriceDto;
import com.example.javatravel.dto.PurchaseDto;
import com.example.javatravel.entity.PriceEntity;
import com.example.javatravel.entity.StandardEntity;
import com.example.javatravel.entity.TripEntity;
import com.example.javatravel.service.PurchaseService;
import com.example.javatravel.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class NewPurchaseController {
    private PurchaseService purchaseService;
    private TripService tripService;

    @Autowired
    public NewPurchaseController(PurchaseService purchaseService, TripService tripService){
        this.purchaseService = purchaseService;
    this.tripService=tripService;}


    @GetMapping("/purchase")
    public String getPurchase (@RequestParam("selectedTripId") Long selectedTripId, Model model){
        TripEntity trip = tripService.getTripById(selectedTripId);
        model.addAttribute("selectedTrip", trip);
        return "/purchase";
    }
    @PostMapping("/purchase")
    public String createPurchase (@RequestParam("selectedTripId") Long selectedTripId,
                                  @RequestParam("adultNumber") Integer adultNumber,
                                  @RequestParam("childNumber") Integer childNumber,
                                  Model model){

        TripEntity selectedTrip = tripService.getTripById(selectedTripId);

    if (selectedTrip !=null){
        PurchaseDto newPurchaseDto = new PurchaseDto();
        newPurchaseDto.setTrip(selectedTrip);
        newPurchaseDto.setAdultNumber(adultNumber);
        newPurchaseDto.setChildNumber(childNumber);
        PurchaseDto purchasedTrip = purchaseService.createPurchase(newPurchaseDto);

        model.addAttribute("purchasedTrip", purchasedTrip);
    }
    return "confirmation";
    }
    public BigDecimal finalPrice (@RequestParam("selectedTripId") Long selectedTripId,
                                  @RequestParam("adultNumber") Integer adultNumber,
                                  @RequestParam("childNumber") Integer childNumber,
                                  Model model) {
        StandardEntity.StandardType standard = StandardEntity.StandardType.OB;

        TripEntity selectedTrip = tripService.getTripById(selectedTripId);

        PriceEntity priceEntity = selectedTrip.getPrices()
                .stream()
                .filter(price -> price.getStandard().getStandardType().equals(standard))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nie znaleziono standardu"));
        BigDecimal finalPrice = BigDecimal.ZERO;
        return
                finalPrice.add(BigDecimal.valueOf(priceEntity.getFlightPrice()*(adultNumber+childNumber)))
        .add(BigDecimal.valueOf(priceEntity.getPricePerDay() * adultNumber))
        .add(BigDecimal.valueOf(priceEntity.getPricePerDay() * childNumber / 2));

    }


}

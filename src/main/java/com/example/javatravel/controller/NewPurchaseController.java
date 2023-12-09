package com.example.javatravel.controller;

import com.example.javatravel.dto.PriceDto;
import com.example.javatravel.dto.PurchaseDto;
import com.example.javatravel.entity.PriceEntity;
import com.example.javatravel.entity.StandardEntity;
import com.example.javatravel.entity.TripEntity;
import com.example.javatravel.service.PurchaseService;
import com.example.javatravel.service.StandardService;
import com.example.javatravel.service.TripService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class NewPurchaseController {
    private PurchaseService purchaseService;
    private TripService tripService;
    private StandardService standardService;

    @Autowired
    public NewPurchaseController(PurchaseService purchaseService, TripService tripService, StandardService standardService){
        this.purchaseService = purchaseService;
    this.tripService=tripService;
    this.standardService=standardService;
    }


    @GetMapping("/purchase")
    public String getPurchase (@RequestParam("selectedTripId") Long selectedTripId, Model model){
        TripEntity trip = tripService.getTripById(selectedTripId);
        model.addAttribute("selectedTrip", trip);
        List<StandardEntity> standards = standardService.getStandardList();
        model.addAttribute("standards", standards);
        return "/purchase";
    }
    @PostMapping("/purchase")
    public String createPurchase (@RequestParam("selectedTripId") Long selectedTripId,
                                  @RequestParam("adultNumber") Integer adultNumber,
                                  @RequestParam("childNumber") Integer childNumber,
                                  @RequestParam("standard") StandardEntity standard,
                                  Model model){

        TripEntity selectedTrip = tripService.getTripById(selectedTripId);
       // StandardEntity selectedStandard = standardService.getStandardByCode(standard);

    if (selectedTrip !=null){
        PurchaseDto newPurchaseDto = new PurchaseDto();
        newPurchaseDto.setTrip(selectedTrip);
        newPurchaseDto.setAdultNumber(adultNumber);
        newPurchaseDto.setChildNumber(childNumber);
        newPurchaseDto.setStandard(standard);
        PurchaseDto purchasedTrip = purchaseService.createPurchase(newPurchaseDto);

        model.addAttribute("purchasedTrip", purchasedTrip);
    }
    return "confirmation";
    }
    public BigDecimal finalPrice (@RequestParam("selectedTripId") Long selectedTripId,
                                  @RequestParam("adultNumber") Integer adultNumber,
                                  @RequestParam("childNumber") Integer childNumber,
                                 @RequestParam("standard") StandardEntity standard)
                                  {
       //StandardEntity.StandardType standard = StandardEntity.StandardType.OB;
      // StandardEntity.StandardType selectedStandard = standardService.getStandardByCode(standard).getStandardType();

        TripEntity selectedTrip = tripService.getTripById(selectedTripId);

        PriceEntity priceEntity = selectedTrip.getPrices()
                .stream()
                .filter(price -> price.getStandard().getStandardType().equals(standard.getStandardType()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nie znaleziono standardu"));
        BigDecimal finalPrice = BigDecimal.ZERO;
        return
                finalPrice.add(BigDecimal.valueOf(priceEntity.getFlightPrice()*(adultNumber+childNumber)))
        .add(BigDecimal.valueOf(priceEntity.getPricePerDay() * adultNumber))
        .add(BigDecimal.valueOf(priceEntity.getPricePerDay() * childNumber / 2));

    }
    @GetMapping("/purchase_price")
    public String displayPrice (@RequestParam("selectedTripId") Long selectedTripId,
                                @RequestParam("adultNumber") Integer adultNumber,
                                @RequestParam("childNumber") Integer childNumber,
                                @RequestParam("standard") StandardEntity standard,
                                Model model) {
        BigDecimal finalPrice = finalPrice(selectedTripId, adultNumber, childNumber, standard);
model.addAttribute("finalPrice", finalPrice);

//        TripEntity trip = tripService.getTripById(selectedTripId);
//        model.addAttribute("selectedTrip", trip);
//        List<StandardEntity> standards = standardService.getStandardList();
//        model.addAttribute("standards", standards);
        return "/purchase";
    }
}

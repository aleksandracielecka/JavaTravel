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
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Controller
public class NewPurchaseController {
    private PurchaseService purchaseService;
    private TripService tripService;
    private StandardService standardService;

    @Autowired
    public NewPurchaseController(PurchaseService purchaseService, TripService tripService, StandardService standardService) {
        this.purchaseService = purchaseService;
        this.tripService = tripService;
        this.standardService = standardService;
    }


    @GetMapping("/purchase")
    public String getPurchase(@RequestParam("selectedTripId") Long selectedTripId, Model model) {
        TripEntity trip = tripService.getTripById(selectedTripId);
        model.addAttribute("selectedTrip", trip);
        List<StandardEntity> standards = standardService.getStandardList();
        model.addAttribute("standards", standards);
        return "/purchase";
    }

    @PostMapping("/purchase")
    public String createPurchase(@RequestParam("selectedTripId") Long selectedTripId,
                                 @RequestParam("adultNumber") Integer adultNumber,
                                 @RequestParam("childNumber") Integer childNumber,
                                 @RequestParam("standard") StandardEntity.StandardType standardType,
                                 Model model) {

        TripEntity selectedTrip = tripService.getTripById(selectedTripId);
         StandardEntity selectedStandard = standardService.getStandardByStandardType(standardType);

        if (selectedTrip != null) {
            PurchaseDto newPurchaseDto = new PurchaseDto();
            newPurchaseDto.setTrip(selectedTrip);
            newPurchaseDto.setAdultNumber(adultNumber);
            newPurchaseDto.setChildNumber(childNumber);
            newPurchaseDto.setStandard(selectedStandard);
            PurchaseDto purchasedTrip = purchaseService.createPurchase(newPurchaseDto);

            model.addAttribute("purchasedTrip", purchasedTrip);

        }
        return "confirmation";
    }

    public BigDecimal getFinalPrice(@RequestParam("selectedTripId") Long selectedTripId,
                                    @RequestParam("adultNumber") Integer adultNumber,
                                    @RequestParam("childNumber") Integer childNumber,
                                    @RequestParam("standard") StandardEntity.StandardType standardType) {
        //StandardEntity.StandardType standard = StandardEntity.StandardType.OB;
//         StandardEntity.StandardType selectedStandard = standardService.getStandardByCode(standard).getStandardType();

        TripEntity selectedTrip = tripService.getTripById(selectedTripId);

        PriceEntity priceEntity = selectedTrip.getPrices()
                .stream()
                .filter(price -> price.getStandard().getStandardType().equals(standardType))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Nie znaleziono standardu"));
        BigDecimal finalPrice = BigDecimal.ZERO;
        double priceByStandard = 0.0;
        if (standardType.equals(StandardEntity.StandardType.BB)) {
            priceByStandard = 1.05;
        }
        if (standardType.equals(StandardEntity.StandardType.HB)) {
            priceByStandard = 1.1;
        }
        if (standardType.equals(StandardEntity.StandardType.FB)) {
            priceByStandard = 1.15;
        }
        if (standardType.equals(StandardEntity.StandardType.AI)) {
            priceByStandard = 1.20;
        }

        LocalDate startDate = selectedTrip.getStartDate();
        LocalDate endDate = selectedTrip.getEndDate();
        Period period = Period.between(startDate, endDate);
        int tripDuration = period.getDays();

        finalPrice = finalPrice.add(BigDecimal.valueOf(priceEntity.getFlightPrice() * (adultNumber + childNumber)))
                .add(BigDecimal.valueOf(priceEntity.getPricePerDay() * adultNumber * priceByStandard * tripDuration))
                .add(BigDecimal.valueOf(priceEntity.getPricePerDay() * childNumber * priceByStandard * tripDuration / 2));

        return finalPrice;


//        return
//                finalPrice.add(BigDecimal.valueOf(priceEntity.getFlightPrice() * (adultNumber + childNumber)))
//                        .add(BigDecimal.valueOf(priceEntity.getPricePerDay() * adultNumber))
//                        .add(BigDecimal.valueOf(priceEntity.getPricePerDay() * childNumber / 2));

    }

    @PostMapping("/purchase_price")
    public String displayPrice(@RequestParam("selectedTripId") Long selectedTripId,
                               @RequestParam("adultNumber") Integer adultNumber,
                               @RequestParam("childNumber") Integer childNumber,
                               @RequestParam("standard") StandardEntity.StandardType standardType,
                               Model model) {
        BigDecimal finalPrice = getFinalPrice(selectedTripId, adultNumber, childNumber, standardType);
        model.addAttribute("finalPrice", finalPrice);

//        TripEntity trip = tripService.getTripById(selectedTripId);
//        model.addAttribute("selectedTrip", trip);
//        List<StandardEntity> standards = standardService.getStandardList();
//        model.addAttribute("standards", standards);
        return "/purchase";
    }
}

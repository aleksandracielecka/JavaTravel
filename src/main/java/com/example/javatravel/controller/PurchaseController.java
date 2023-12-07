package com.example.javatravel.controller;

import com.example.javatravel.dto.PurchaseDto;
import com.example.javatravel.entity.TripEntity;
import com.example.javatravel.service.PurchaseService;
import com.example.javatravel.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PurchaseController {
    private PurchaseService purchaseService;
    private TripService tripService;

    @Autowired
    public PurchaseController(PurchaseService purchaseService){this.purchaseService = purchaseService;}

    @PostMapping("/purchase")
    public String createPurchase (@RequestParam("selectedTripId") Long selectedTripId){

        TripEntity selectedTrip = tripService.getTripById(selectedTripId);

    if (selectedTrip !=null){
        PurchaseDto newPurchaseDto = new PurchaseDto();
        newPurchaseDto.setTrip(selectedTrip);

    }
    return "redirect:/purchase";
    }


}

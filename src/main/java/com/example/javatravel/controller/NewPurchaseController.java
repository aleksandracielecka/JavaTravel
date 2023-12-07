package com.example.javatravel.controller;

import com.example.javatravel.dto.PurchaseDto;
import com.example.javatravel.entity.TripEntity;
import com.example.javatravel.service.PurchaseService;
import com.example.javatravel.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
                                  @RequestParam("childNumber") Integer childNumber){

        TripEntity selectedTrip = tripService.getTripById(selectedTripId);

    if (selectedTrip !=null){
        PurchaseDto newPurchaseDto = new PurchaseDto();
        newPurchaseDto.setTrip(selectedTrip);
        newPurchaseDto.setAdultNumber(adultNumber);
        newPurchaseDto.setChildNumber(childNumber);
    }
    return "redirect:/purchase";
    }


}

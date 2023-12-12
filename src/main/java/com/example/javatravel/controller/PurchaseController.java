package com.example.javatravel.controller;

import com.example.javatravel.entity.PurchaseEntity;
import com.example.javatravel.entity.TripEntity;
import com.example.javatravel.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/purchases", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PurchaseController {

    private final PurchaseService purchaseService;

    @GetMapping
    public ResponseEntity<List<PurchaseEntity>> getPurchaseList(){
        try {
            List<PurchaseEntity> purchases = purchaseService.getPurchaseList();
            return ResponseEntity.ok(purchases);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/purchases")
    public String getPurchaseListInView(Model model){
        List<PurchaseEntity> purchases = purchaseService.getPurchaseList();
        model.addAttribute("purchases",purchases);
        return "purchases";
    }


}

package com.example.javatravel.controller;

import com.example.javatravel.dto.PriceDto;
import com.example.javatravel.entity.PriceEntity;
import com.example.javatravel.service.PriceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/prices", produces = {MediaType.APPLICATION_JSON_VALUE})
public class PriceController {

    private final PriceService priceService;

    @GetMapping
    public ResponseEntity<List<PriceEntity>> getPriceList() {
        try {
            List<PriceEntity> prices = priceService.getPriceList();
            return ResponseEntity.ok(prices);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PostMapping
    public ResponseEntity<PriceDto> addPrice(@RequestBody PriceDto priceDto) {
        try {
            PriceDto addPrice = priceService.addPrice(priceDto);
            return ResponseEntity.ok(addPrice);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<PriceEntity> updatePrice(@RequestBody PriceEntity price) {
        try {
            PriceEntity updatePrice = priceService.updatePrice(price);
            return ResponseEntity.ok(updatePrice);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrice(@PathVariable Long id) {
        try {
            priceService.deletePrice(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

}

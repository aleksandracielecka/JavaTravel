package com.example.javatravel.service;

import com.example.javatravel.controller.NewPurchaseController;
import com.example.javatravel.entity.PriceEntity;
import com.example.javatravel.entity.TripEntity;
import com.example.javatravel.entity.enums.StandardType;
import com.example.javatravel.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;
import java.time.Period;
@Service
@RequiredArgsConstructor
public class TripFinalPriceService {


    private final TripRepository tripRepository;



    public BigDecimal getFinalPrice(Long selectedTripId, Integer adultNumber,
                                    Integer childNumber, StandardType standardType) {

        TripEntity selectedTrip = tripRepository.findById(selectedTripId).orElseThrow();
        PriceEntity priceEntity = selectedTrip.getPrice();

        double priceByStandard = getPriceByStandard(standardType);
        int tripDuration = getTripDuration(selectedTrip);

        BigDecimal finalPrice = BigDecimal.ZERO;
        finalPrice = finalPrice.add(BigDecimal.valueOf(priceEntity.getFlightPrice() * (adultNumber + childNumber)))
                .add(BigDecimal.valueOf(priceEntity.getPricePerDay() * adultNumber * priceByStandard * tripDuration))
                .add(BigDecimal.valueOf(priceEntity.getPricePerDay() * childNumber * priceByStandard * tripDuration / 2));

        return finalPrice.setScale(2, MathContext.DECIMAL32.getRoundingMode());
    }

    public static int getTripDuration(TripEntity selectedTrip) {
        LocalDate startDate = selectedTrip.getStartDate();
        LocalDate endDate = selectedTrip.getEndDate();
        Period period = Period.between(startDate, endDate);
        return period.getDays();
    }

    public static double getPriceByStandard(StandardType standardType) {
        double priceByStandard = 0.0;
        if (standardType.equals(StandardType.OB)) {
            priceByStandard = 1.00;
        }
        if (standardType.equals(StandardType.BB)) {
            priceByStandard = 1.10;
        }
        if (standardType.equals(StandardType.HB)) {
            priceByStandard = 1.25;
        }
        if (standardType.equals(StandardType.FB)) {
            priceByStandard = 1.30;
        }
        if (standardType.equals(StandardType.AI)) {
            priceByStandard = 1.40;
        }
        return priceByStandard;
    }
}
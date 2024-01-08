//package com.example.javatravel.service;
//
//import com.example.javatravel.entity.TripEntity;
//import com.example.javatravel.entity.enums.StandardType;
//import com.example.javatravel.repository.PriceRepository;
//import com.example.javatravel.repository.TripRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(MockitoExtension.class)
//class TripFinalPriceServiceTest {
//
//@InjectMocks
//    private TripFinalPriceService tripFinalPriceService;
//    @Mock
//    private TripRepository tripRepository;
//    @Mock
//    private PriceRepository priceRepository;
//    @Test
//    void shouldCalculateTripFinalPrice() {
//        //given
////Mockito.when(tripRepository.findById(1L)).thenReturn(Optional.of(TripEntity.builder()
////                .id(1L)
////                .price(priceRepository.getPriceById(1L))
////                .airportFrom(tripRepository.findById(1L))
//        Mockito.when(tripRepository.findById(1L)).thenReturn(Optional.ofNullable(TripEntity.builder()
//                .id(1L)
//                .price(tripRepository.findById(1L).get().getPrice())
//                .airportFrom(tripRepository.findById(1L).get().getAirportFrom())
//                .airportTo(tripRepository.findById(1L).get().getAirportTo())
////                .endDate(LocalDate.of(2024,01,7))
//                .startDate(LocalDate.of(2024,01,5))
//                .endDate(LocalDate.of(2024,01,7))
////                .startDate(LocalDate.of(2024,01,5))
//                .hotel(tripRepository.findById(1L).get().getHotel())
//                .maxAdultNumber(2)
//                .maxChildNumber(0)
//
//                .build()));
//        //when
//        BigDecimal finalPrice = tripFinalPriceService.getFinalPrice(1L, 2, 0, StandardType.OB);
//        //then
//        assertEquals(BigDecimal.ZERO,finalPrice);
//
//    }
//}
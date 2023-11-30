package com.example.javatravel.service;

import com.example.javatravel.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TripService {
    private final TripRepository tripRepository;
    // metody delete update create read


}

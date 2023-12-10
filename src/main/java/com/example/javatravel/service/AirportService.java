package com.example.javatravel.service;


import com.example.javatravel.dto.AirportDto;
import com.example.javatravel.entity.AirportEntity;
import com.example.javatravel.repository.AirportRepository;
import com.example.javatravel.utils.mapper.AirportMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportService {

    private final AirportRepository airportRepository;

    public List<AirportEntity> getAirportList() {
        return airportRepository.findAll();
    }

    public AirportDto addAirport(AirportDto airportDto) {
        AirportEntity airportEntity = AirportMapper.toAirportEntity(airportDto);
        AirportEntity addAirport = airportRepository.save(airportEntity);
        return AirportMapper.toAirportDto(addAirport);
    }

    public AirportEntity updateAirport(AirportEntity airport) {
        return airportRepository.save(airport);
    }

    @Transactional
    public void deleteAirport(String code) {
        if (!airportRepository.existsById(code)) {
            throw new EntityNotFoundException("Airport not found" + code);
        }
        airportRepository.deleteById(code);
    }


    public AirportEntity getAirportCode(String code) {
        return airportRepository.getByCode(code);

    }
}


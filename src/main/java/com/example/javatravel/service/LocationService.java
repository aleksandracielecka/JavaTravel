package com.example.javatravel.service;

import com.example.javatravel.dto.LocationDto;
import com.example.javatravel.entity.LocationEntity;
import com.example.javatravel.repository.LocationRepository;
import com.example.javatravel.utils.mapper.LocationMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationService {
    private final LocationRepository locationRepository;

    public List<LocationDto> getLocationList(){
        List<LocationDto> locationDtoList = new ArrayList<>();
        List<LocationEntity> locationEntityList = locationRepository.findAll();
        for (LocationEntity locationEntity : locationEntityList){
            LocationDto locationDto = LocationMapper.toLocationDto(locationEntity);
            locationDtoList.add(locationDto);
        }
        return locationDtoList;
    }

    public void  deleteLocation(Long id) {
        if(!locationRepository.existsById(id)){
            throw new EntityNotFoundException("Location not found" + id);
        }
        locationRepository.deleteById(id);
    }

    public LocationDto updateLocation(LocationDto locationDto) {
        if(!locationRepository.existsById(locationDto.getId())){
            throw new EntityNotFoundException("Location not found" + locationDto.getId());
        }
        LocationEntity locationEntity = LocationMapper.toLocationEntity(locationDto);
        LocationEntity savedLocationEntity = locationRepository.save(locationEntity);
        LocationDto dto = LocationMapper.toLocationDto(savedLocationEntity);
        return dto;
    }

    public LocationDto addLocation(LocationDto locationDto){
        LocationEntity locationEntity = LocationMapper.toLocationEntity(locationDto);
        LocationEntity savedLocationEntity = locationRepository.save(locationEntity);
        LocationDto dto = LocationMapper.toLocationDto(savedLocationEntity);
        return dto;
    }

    public Set<LocationEntity.Continent> getLocationSet(){
        Set<LocationEntity.Continent> continents = new HashSet<>();
        continents= locationRepository.findAll()
                .stream()
                .map(LocationEntity::getContinent)
                .collect(Collectors.toSet());
        return continents;
    }
}

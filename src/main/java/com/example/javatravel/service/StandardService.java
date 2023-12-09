package com.example.javatravel.service;

import com.example.javatravel.entity.StandardEntity;
import com.example.javatravel.repository.StandardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StandardService {

    private final StandardRepository standardRepository;

    public List<StandardEntity> getStandardList(){
        return standardRepository.findAll();
    }

    public StandardEntity getStandardByCode(String code) {
        return standardRepository.findById(code).orElseThrow(() -> new RuntimeException("Nie znaleziono standardu!"));
    }

    public StandardEntity getStandardByStandardType(StandardEntity.StandardType standardType) {
        return standardRepository.findByStandardType(standardType);
    }
}

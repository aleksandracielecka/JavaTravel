package com.example.javatravel.service;

import com.example.javatravel.entity.StandardEntity;
import com.example.javatravel.repository.StandardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StandardService {

    private final StandardRepository standardRepository;

    public List<StandardEntity> getStandardList(){
        return standardRepository.findAll();
    }

    public StandardEntity getStandardByCode(String code) {
        return standardRepository.getReferenceById(code);
    }
}

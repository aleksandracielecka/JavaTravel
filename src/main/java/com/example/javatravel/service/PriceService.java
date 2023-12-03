package com.example.javatravel.service;

import com.example.javatravel.dto.PriceDto;
import com.example.javatravel.entity.PriceEntity;
import com.example.javatravel.repository.PriceRepository;
import com.example.javatravel.utils.mapper.PriceMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PriceService {

    private final PriceRepository priceRepository;

    public List<PriceEntity> getPriceList() {
        return priceRepository.findAll();
    }

    public PriceDto addPrice(PriceDto priceDto) {
        PriceEntity priceEntity = PriceMapper.toPriceEntity(priceDto);
        PriceEntity addPrice = priceRepository.save(priceEntity);
        return PriceMapper.toPriceDto(addPrice);
    }

    public PriceEntity updatePrice(PriceEntity price) {
        return priceRepository.save(price);
    }

    @Transactional
    public void deletePrice(Long id) {
        if (!priceRepository.existsById(id)) {
            throw new EntityNotFoundException("Price not found " + id);
        }
        priceRepository.deleteById(id);
    }

}

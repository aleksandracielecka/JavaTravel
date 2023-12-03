package com.example.javatravel.utils.mapper;

import com.example.javatravel.dto.PriceDto;
import com.example.javatravel.entity.PriceEntity;

public class PriceMapper {

    public static PriceEntity toPriceEntity(PriceDto priceDto) {
        PriceEntity priceEntity = new PriceEntity();
        priceEntity.setId(priceDto.getId());
        priceEntity.setPricePerDay(priceDto.getPricePerDay());
        priceEntity.setFlightPrice(priceDto.getFlightPrice());
        priceEntity.setStandard(priceDto.getStandard());
        return priceEntity;
    }

    public static PriceDto toPriceDto(PriceEntity priceEntity) {
        PriceDto priceDto = new PriceDto();
        priceDto.setId(priceEntity.getId());
        priceDto.setPricePerDay(priceEntity.getPricePerDay());
        priceDto.setFlightPrice(priceEntity.getFlightPrice());
        priceDto.setStandard(priceEntity.getStandard());
        return priceDto;
    }

}

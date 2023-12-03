package com.example.javatravel.utils.mapper;


import com.example.javatravel.dto.HotelDto;
import com.example.javatravel.entity.HotelEntity;

public class HotelMapper {

    public static HotelEntity toHotelEntity(HotelDto hotelDto){
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setId(hotelDto.getId());
        hotelEntity.setName(hotelDto.getName());
        hotelEntity.setDescription(hotelDto.getDescription());
        hotelEntity.setStars(hotelDto.getStars());
        hotelEntity.setLocation(hotelDto.getLocation());
        return hotelEntity;

    }

    public static HotelDto toHotelDto(HotelEntity hotelEntity){
        HotelDto hotelDto = new HotelDto();
        hotelDto.setId(hotelEntity.getId());
        hotelDto.setName(hotelEntity.getName());
        hotelDto.setDescription(hotelEntity.getDescription());
        hotelDto.setStars(hotelEntity.getStars());
        hotelDto.setLocation(hotelEntity.getLocation());
        return hotelDto;
    }
}

package com.example.javatravel;

import com.example.javatravel.dto.LocationDto;
import com.example.javatravel.entity.LocationEntity;
import com.example.javatravel.utils.mapper.LocationMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LocationMapperTest {

    @Test
    void shouldMapDtoToEntity() {
        // given
        LocationDto locationDto = new LocationDto();
        locationDto.setId(1L);
        locationDto.setAddress("testAddress");
        locationDto.setCity("testCity");
        locationDto.setContinent(LocationEntity.Continent.AUSTRALIA);
        locationDto.setCountry("testCountry");
        //when
        LocationEntity locationEntity = LocationMapper.toLocationEntity(locationDto);
        //then
        Assertions.assertEquals(locationEntity.getId(),1L);
        Assertions.assertEquals(locationEntity.getAddress(),"testAddress");
        Assertions.assertEquals(locationEntity.getCity(),"testCity");
        Assertions.assertEquals(locationEntity.getContinent(),LocationEntity.Continent.AUSTRALIA);
        Assertions.assertEquals(locationEntity.getCountry(),"testCountry");


    }
}

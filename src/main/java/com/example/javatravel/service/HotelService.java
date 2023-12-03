package com.example.javatravel.service;

import com.example.javatravel.dto.HotelDto;
import com.example.javatravel.entity.HotelEntity;
import com.example.javatravel.repository.HotelRepository;
import com.example.javatravel.utils.mapper.HotelMapper;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HotelService {
    private final HotelRepository hotelRepository;

    public List<HotelEntity> getHotelList(){
        return hotelRepository.findAll();
    }

    public HotelDto addHotel(HotelDto hotelDto){
        HotelEntity hotelEntity = HotelMapper.toHotelEntity(hotelDto);
        HotelEntity addHotel = hotelRepository.save(hotelEntity);
        return HotelMapper.toHotelDto(addHotel);
    }

    public HotelEntity updateHotel(HotelEntity hotel){
        return hotelRepository.save(hotel);
    }

    @Transactional
    public void deleteHotel(Long id){
        if (!hotelRepository.existsById(id)){
            throw new EntityNotFoundException("Hotel not found" + id);
        }
        hotelRepository.deleteById(id);
    }




    public HotelEntity getHotelById(Long selectedHotelId) {
        return hotelRepository.getReferenceById(selectedHotelId);
    }
}

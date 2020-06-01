package com.fake.travel.impl;

import com.fake.travel.dto.PlaceDTO;
import com.fake.travel.entity.Place;
import com.fake.travel.mapper.PlaceMapper;
import com.fake.travel.repository.PlaceRepository;
import com.fake.travel.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private PlaceMapper placeMapper;

    @Override
    public List<PlaceDTO> getAllPlaces() {
        List<PlaceDTO> placeDTOS = new ArrayList<>();
        List<Place> places = placeRepository.findAll();
        for(Place place : places)
        {
            placeDTOS.add(placeMapper.toDto(place));
        }
        return placeDTOS;
    }
}

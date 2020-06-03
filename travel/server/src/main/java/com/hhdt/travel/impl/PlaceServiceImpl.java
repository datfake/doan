package com.hhdt.travel.impl;

import com.hhdt.travel.dto.PlaceDTO;
import com.hhdt.travel.entity.Place;
import com.hhdt.travel.mapper.PlaceMapper;
import com.hhdt.travel.repository.PlaceRepository;
import com.hhdt.travel.service.PlaceService;
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

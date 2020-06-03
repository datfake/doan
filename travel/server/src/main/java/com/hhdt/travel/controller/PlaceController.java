package com.hhdt.travel.controller;

import com.hhdt.travel.dto.PlaceDTO;
import com.hhdt.travel.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/place")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @GetMapping
    public List<PlaceDTO>  getAllPlaces(){
        return placeService.getAllPlaces();
    }
}

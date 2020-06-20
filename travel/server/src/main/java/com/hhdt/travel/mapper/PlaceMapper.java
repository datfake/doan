package com.hhdt.travel.mapper;

import com.hhdt.travel.dto.PlaceDTO;
import com.hhdt.travel.entity.Place;
import org.springframework.stereotype.Component;

@Component
public class PlaceMapper {
    public PlaceDTO toDto(Place place){
        PlaceDTO placeDTO = new PlaceDTO();
        placeDTO.setId(place.getId());
        placeDTO.setAddress(place.getAddress());
        placeDTO.setContent(place.getContent());
        placeDTO.setName(place.getName());
        placeDTO.setImage(place.getImage());
        placeDTO.setIdProvince(place.getProvince().getId());
        try {
            placeDTO.setIdImage(place.getImg().getData());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return placeDTO;
    }

    public Place toEntity(PlaceDTO placeDTO){
        Place place = new Place();
        place.setId(placeDTO.getId());
        place.setAddress(placeDTO.getAddress());
        place.setContent(placeDTO.getContent());
        place.setImage(placeDTO.getImage());
        place.setName(placeDTO.getName());
        return place;
    }
}

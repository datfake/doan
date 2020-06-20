package com.hhdt.travel.controller;

import com.hhdt.travel.dto.PlaceDTO;
import com.hhdt.travel.dto.PlaceInputDTO;
import com.hhdt.travel.entity.Image;
import com.hhdt.travel.entity.Place;
import com.hhdt.travel.entity.Province;
import com.hhdt.travel.repository.ImageRepository;
import com.hhdt.travel.repository.PlaceRepository;
import com.hhdt.travel.repository.ProvinceRepository;
import com.hhdt.travel.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/place")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping
    public List<PlaceDTO>  getAllPlaces(){
        return placeService.getAllPlaces();
    }

    @PostMapping("/uploadImage")
    public long uploadImage(@RequestBody MultipartFile file) throws IOException
    {
        Image image = new Image();
        image.setData(file.getBytes());
        Image image1 = imageRepository.save(image);
        return image1.getId();
    }

    @PostMapping("/create")
    public String createPlace(@RequestBody PlaceInputDTO placeInputDTO) throws IOException
    {
       try {
           Place place = new Place();
           place.setName(placeInputDTO.getName());
           place.setAddress(placeInputDTO.getAddress());
           place.setContent(placeInputDTO.getContent());
           Image image = imageRepository.findById(placeInputDTO.getIdImage()).get();
           Province province = provinceRepository.findById(placeInputDTO.getIdProvince()).get();
           place.setImage("");
           place.setImg(image);
           place.setProvince(province);
           Place place1 =placeRepository.save(place);
           return "them thanh cong";
       }catch (Exception e)
       {
           return "them that bai";
       }

    }
    @DeleteMapping("/del")
    public String delete(@RequestBody List<Long> ids)
    {
        for(long id : ids)
        {
            placeRepository.deleteById(id);
        }
        return "xóa thành công";
    }

}

package com.fake.travel.controller;

import com.fake.travel.entity.Province;
import com.fake.travel.repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/province")
public class ProvinceController {
    @Autowired
    private ProvinceRepository provinceRepository;

    @GetMapping
    public List<Province> getALlProvince()
    {
        return provinceRepository.findAll();
    }
}

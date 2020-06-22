package com.hhdt.travel.controller;

import com.hhdt.travel.entity.Province;
import com.hhdt.travel.repository.ProvinceRepository;
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

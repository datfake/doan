package com.hhdt.travel.controller;

import com.hhdt.travel.dto.RegisterDTO;
import com.hhdt.travel.entity.UserEntity;
import com.hhdt.travel.mapper.UserMapper;
import com.hhdt.travel.repository.UserRepository;
import com.hhdt.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @GetMapping
    public List<RegisterDTO> getAllUsers()
    {
        List<UserEntity> userEntities = userService.getALlUsers();
        List<RegisterDTO> registerDTOS = new ArrayList<>();
        for(UserEntity userEntity : userEntities)
        {
            registerDTOS.add(userMapper.toDto(userEntity));
        }
        return registerDTOS;
    }
}

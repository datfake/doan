package com.hhdt.travel.impl;

import com.hhdt.travel.entity.UserEntity;
import com.hhdt.travel.repository.UserRepository;
import com.hhdt.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserEntity> getALlUsers() {
        return userRepository.findAll();
    }
}

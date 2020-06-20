package com.hhdt.travel.mapper;

import com.hhdt.travel.dto.RegisterDTO;
import com.hhdt.travel.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public RegisterDTO toDto(UserEntity userEntity)
    {
        RegisterDTO registerDTO = new RegisterDTO();
        registerDTO.setEmail(userEntity.getEmail());
        registerDTO.setFullName(userEntity.getFullName());
        return  registerDTO;
    }
}

package com.hhdt.travel.controller;

import com.hhdt.travel.dto.RegisterDTO;
import com.hhdt.travel.dto.UserDTO;
import com.hhdt.travel.entity.UserEntity;
import com.hhdt.travel.mapper.UserMapper;
import com.hhdt.travel.repository.UserRepository;
import com.hhdt.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public List<UserDTO> getAllUsers()
    {
        List<UserEntity> userEntities = userService.getALlUsers();
        List<UserDTO> registerDTOS = new ArrayList<>();
        for(UserEntity userEntity : userEntities)
        {
            registerDTOS.add(userMapper.toDtoo(userEntity));
        }
        return registerDTOS;
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/del")
    public String delete(@RequestBody long[] ids)
    {
        for(long id : ids)
        {
            userRepository.deleteById(id);
        }
        return "xóa thành công";
    }

}

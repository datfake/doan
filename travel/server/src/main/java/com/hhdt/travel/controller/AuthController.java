package com.hhdt.travel.controller;

import com.hhdt.travel.config.TokenProvider;
import com.hhdt.travel.dto.AuthTokenDTO;
import com.hhdt.travel.dto.LoginDTO;
import com.hhdt.travel.dto.RegisterDTO;
import com.hhdt.travel.entity.Role;
import com.hhdt.travel.entity.UserEntity;
import com.hhdt.travel.repository.RoleRepository;
import com.hhdt.travel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(),
                        loginDTO.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        UserEntity userEntity = userRepository.findByEmail(loginDTO.getEmail()).get();
        long roleid = userEntity.getRoles().size()>1 ?2:1;
        return ResponseEntity.ok(new AuthTokenDTO(userEntity.getId(),loginDTO.getEmail(),userEntity.getFullName(),token,roleid));
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterDTO registerDTO) {
        if(userRepository.findByEmail(registerDTO.getEmail()).isPresent()) return null;
        else {
            UserEntity user = new UserEntity(registerDTO.getEmail(), registerDTO.getFullName(), new BCryptPasswordEncoder().encode(registerDTO.getPassword()));
            Role role = roleRepository.findById(2);
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
            userRepository.save(user);
            return "Đăng ký thành công";
        }
    }

    @PostMapping("/register-admin")
    public void registerAdmin(@RequestBody RegisterDTO registerDTO) {
        UserEntity user = new UserEntity(registerDTO.getEmail(), registerDTO.getFullName(), new BCryptPasswordEncoder().encode(registerDTO.getPassword()));
        Role role = roleRepository.findById(2);
        Role roleAdmin = roleRepository.findById(1);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        roles.add(roleAdmin);
        user.setRoles(roles);
        userRepository.save(user);
    }
}

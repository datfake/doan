package com.hhdt.travel.config;

import com.hhdt.travel.repository.RoleRepository;
import com.hhdt.travel.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
@Configuration
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private void addRoleIfMissing(String name, String description){
        if (roleRepository.findByName(name) == null) {
            roleRepository.save(new com.hhdt.travel.entity.Role(name, description));
        }
    }

    private void addUserIfMissing(String email, String password, String... roles){
        if (userRepository.findByEmail(email) == null) {
            com.hhdt.travel.entity.UserEntity user = new com.hhdt.travel.entity.UserEntity(email, "Full Name", new BCryptPasswordEncoder().encode(password));
            user.setRoles(new HashSet<>());

            for (String role: roles) {
                user.getRoles().add(roleRepository.findByName(role).get());
            }
            userRepository.save(user);
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if(signingKey == null || signingKey.length() ==0){
            String jws = Jwts.builder()
                    .setSubject("Travel")
                    .signWith(SignatureAlgorithm.HS256, "TravelAPI").compact();

            System.out.println("Use this jwt key:");
            System.out.println("jwt-key=" + jws);
        }
    }

    @Value("${jwt-key}")
    private String signingKey;
}
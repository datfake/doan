package com.hhdt.travel.repository;

import com.hhdt.travel.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity>  findByEmail(String email);

    com.hhdt.travel.entity.UserEntity findOneById(Long aLong);
}
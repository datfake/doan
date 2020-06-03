package com.hhdt.travel.repository;

import com.hhdt.travel.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlaceRepository extends JpaRepository<Place,Long> {

    Place findOneById(Long aLong);
}

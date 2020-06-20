package com.hhdt.travel.repository;

import com.hhdt.travel.dto.PostOutputDTO;
import com.hhdt.travel.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    Post findOneById(Long id);

    @Query(value = "SELECT new com.fake.travel.dto.PostOutputDTO(p.id, pl.name, pl.address, p.content, u.fullName, i.data) " +
            " FROM com.fake.travel.entity.Post p join com.fake.travel.entity.UserEntity u on p.user.id = u.id " +
            "join com.fake.travel.entity.Place pl on pl.id = p.place.id" +
            " join com.fake.travel.entity.Image i on i.id = pl.img.id")
    List<PostOutputDTO> getAllPost();
}

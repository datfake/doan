package com.fake.travel.repository;

import com.fake.travel.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {
    Post findOneById(Long id);

    @Query(value = "SELECT p.id, p.content, pl.image , u.full_name " +
            "FROM post p join users u on p.id_user = u.id join place pl on pl.id = p.id_place", nativeQuery = true)
    List<Object[]> getAllPost();
}

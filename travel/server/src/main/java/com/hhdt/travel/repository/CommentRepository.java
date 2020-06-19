package com.hhdt.travel.repository;

import com.hhdt.travel.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    @Query(value = "SELECT c.id, c.content , u.full_name " +
            "FROM comment c join users u on c.id_user = u.id join post p on p.id = c.id_post where c.id_post = ?1", nativeQuery = true)
    List<Object[]> findAllCommentByPostId(Long id);
}

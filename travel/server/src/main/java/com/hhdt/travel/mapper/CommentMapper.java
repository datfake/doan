package com.fake.travel.mapper;


import com.fake.travel.dto.CommentDTO;
import com.fake.travel.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {
    public CommentDTO toDto(Comment post)
    {
        CommentDTO postDTO = new CommentDTO();
        postDTO.setContent(post.getContent());
        postDTO.setIdUser(post.getUser().getId());
        postDTO.setIdPost(post.getPost().getId());
        return postDTO;
    }

    public Comment toEntity(CommentDTO postDTO)
    {
        Comment post = new Comment();
        post.setContent(postDTO.getContent());
        return post;
    }
}

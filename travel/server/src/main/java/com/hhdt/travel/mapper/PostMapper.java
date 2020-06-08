package com.fake.travel.mapper;

import com.fake.travel.dto.PostDTO;
import com.fake.travel.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    public PostDTO toDto(Post post)
    {
        PostDTO postDTO = new PostDTO();
        postDTO.setContent(post.getContent());
        postDTO.setIdUser(post.getUser().getId());
        postDTO.setIdPlace(post.getPlace().getId());
        return postDTO;
    }

    public Post toEntity(PostDTO postDTO)
    {
        Post post = new Post();
        post.setContent(postDTO.getContent());
        return post;
    }
}

package com.fake.travel.controller;

import com.fake.travel.dto.PlaceDTO;
import com.fake.travel.dto.PostDTO;
import com.fake.travel.dto.PostOutputDTO;
import com.fake.travel.entity.Place;
import com.fake.travel.entity.Post;
import com.fake.travel.entity.UserEntity;
import com.fake.travel.mapper.PostMapper;
import com.fake.travel.repository.PlaceRepository;
import com.fake.travel.repository.PostRepository;
import com.fake.travel.repository.UserRepository;
import com.fake.travel.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/create")
    public PostDTO create(@RequestBody PostDTO postDTO)
    {
        return postService.create(postDTO);
    }

    @GetMapping
    public List<PostOutputDTO> getAllPost()
    {
        return postService.getAllPost();
    }

}

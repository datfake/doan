package com.hhdt.travel.controller;

import com.hhdt.travel.dto.PlaceDTO;
import com.hhdt.travel.dto.PostDTO;
import com.hhdt.travel.dto.PostOutputDTO;
import com.hhdt.travel.entity.Place;
import com.hhdt.travel.entity.Post;
import com.hhdt.travel.entity.UserEntity;
import com.hhdt.travel.mapper.PostMapper;
import com.hhdt.travel.repository.PlaceRepository;
import com.hhdt.travel.repository.PostRepository;
import com.hhdt.travel.repository.UserRepository;
import com.hhdt.travel.service.PostService;
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

package com.fake.travel.service;

import com.fake.travel.dto.PostDTO;
import com.fake.travel.dto.PostOutputDTO;

import java.util.List;

public interface PostService {

    public PostDTO create(PostDTO postDTO);

    public List<PostOutputDTO> getAllPost();
}

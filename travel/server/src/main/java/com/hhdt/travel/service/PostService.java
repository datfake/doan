package com.hhdt.travel.service;

import com.hhdt.travel.dto.PostDTO;
import com.hhdt.travel.dto.PostOutputDTO;

import java.util.List;

public interface PostService {

    public PostDTO create(PostDTO postDTO);

    public List<PostOutputDTO> getAllPost();
}

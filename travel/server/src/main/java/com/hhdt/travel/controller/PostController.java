package com.hhdt.travel.controller;

import com.hhdt.travel.dto.PostDTO;
import com.hhdt.travel.dto.PostOutputDTO;
import com.hhdt.travel.repository.PostRepository;
import com.hhdt.travel.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/post")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private PostRepository postRepository;

    @PostMapping("/create")
    @CrossOrigin(origins = { "*" })
    public PostDTO create(@RequestBody PostDTO postDTO)
    {
        return postService.create(postDTO);
    }

    @GetMapping
    @CrossOrigin(origins = { "*" })
    public List<PostOutputDTO> getAllPost()
    {
        return postService.getAllPost();
    }

    @DeleteMapping("/del")
    @CrossOrigin(origins = { "*" })
    public String delete(@RequestBody List<Long> ids)
    {
        for(long id : ids)
        {
            postRepository.deleteById(id);
        }
        return "xóa thành công";
    }

}

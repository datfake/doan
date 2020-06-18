package com.fake.travel.controller;

import com.fake.travel.dto.CommentDTO;
import com.fake.travel.dto.CommentOutputDTO;
import com.fake.travel.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    public CommentDTO create(@RequestBody CommentDTO commentDTO)
    {
        return commentService.create(commentDTO);
    }

    @GetMapping("/{id}")
    public List<CommentOutputDTO> getListCommentByIdPost(@PathVariable Long id)
    {
        return commentService.getListCommentByIdPost(id);
    }
}

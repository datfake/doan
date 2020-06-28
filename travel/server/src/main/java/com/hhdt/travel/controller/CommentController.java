package com.hhdt.travel.controller;

import com.hhdt.travel.dto.CommentDTO;
import com.hhdt.travel.dto.CommentOutputDTO;
import com.hhdt.travel.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/create")
    @CrossOrigin(origins = { "*" })
    public CommentDTO create(@RequestBody CommentDTO commentDTO)
    {
        return commentService.create(commentDTO);
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = { "*" })
    public List<CommentOutputDTO> getListCommentByIdPost(@PathVariable Long id)
    {
        return commentService.getListCommentByIdPost(id);
    }
}

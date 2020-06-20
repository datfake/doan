package com.hhdt.travel.service;

import com.hhdt.travel.dto.CommentDTO;
import com.hhdt.travel.dto.CommentOutputDTO;

import java.util.List;

public interface CommentService {
    public CommentDTO create(CommentDTO commentDTO);

    public List<CommentOutputDTO> getListCommentByIdPost(Long id);
}

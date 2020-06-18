package com.fake.travel.service;

import com.fake.travel.dto.CommentDTO;
import com.fake.travel.dto.CommentOutputDTO;

import java.util.List;

public interface CommentService {
    public CommentDTO create(CommentDTO commentDTO);

    public List<CommentOutputDTO> getListCommentByIdPost(Long id);
}

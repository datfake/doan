package com.fake.travel.impl;

import com.fake.travel.dto.CommentDTO;
import com.fake.travel.dto.CommentOutputDTO;
import com.fake.travel.entity.Comment;
import com.fake.travel.entity.Post;
import com.fake.travel.entity.UserEntity;
import com.fake.travel.mapper.CommentMapper;
import com.fake.travel.repository.CommentRepository;
import com.fake.travel.repository.PostRepository;
import com.fake.travel.repository.UserRepository;
import com.fake.travel.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public CommentDTO create(CommentDTO commentDTO) {
        Comment comment = commentMapper.toEntity(commentDTO);
        UserEntity userEntity = userRepository.findOneById(commentDTO.getIdUser());
        comment.setUser(userEntity);
        Post post = postRepository.findOneById(commentDTO.getIdPost());
        comment.setPost(post);
        commentRepository.save(comment);
        return commentDTO;
    }

    @Override
    public List<CommentOutputDTO> getListCommentByIdPost(Long id) {
        List<CommentOutputDTO> commentDTOS = new ArrayList<>();
        List<Object[]> objects = commentRepository.findAllCommentByPostId(id);
        for(Object[] object : objects)
        {
            commentDTOS.add(new CommentOutputDTO(Long.valueOf(object[0].toString()),object[1].toString(),object[2].toString()));
        }
        return commentDTOS;
    }
}

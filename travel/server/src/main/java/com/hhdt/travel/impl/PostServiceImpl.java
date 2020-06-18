package com.hhdt.travel.impl;

import com.hhdt.travel.dto.CommentOutputDTO;
import com.hhdt.travel.dto.PostDTO;
import com.hhdt.travel.dto.PostOutputDTO;
import com.hhdt.travel.entity.Place;
import com.hhdt.travel.entity.Post;
import com.hhdt.travel.entity.UserEntity;
import com.hhdt.travel.mapper.PostMapper;
import com.hhdt.travel.repository.PlaceRepository;
import com.hhdt.travel.repository.PostRepository;
import com.hhdt.travel.repository.UserRepository;
import com.hhdt.travel.service.CommentService;
import com.hhdt.travel.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentService commentService;

    @Override
    public PostDTO create(PostDTO postDTO) {
        Post post = postMapper.toEntity(postDTO);
        UserEntity userEntity = userRepository.findOneById(postDTO.getIdUser());
        post.setUser(userEntity);
        Place place = placeRepository.findOneById(postDTO.getIdPlace());
        post.setPlace(place);
        postRepository.save(post);
        return postDTO;
    }

    @Override
    public List<PostOutputDTO> getAllPost() {
        List<Object[]> objects = postRepository.getAllPost();
        List<PostOutputDTO> postOutputDTOS = new ArrayList<>();
        for(Object[] object : objects)
        {
            List<CommentOutputDTO> commentOutputDTOS = commentService.getListCommentByIdPost(Long.valueOf(object[0].toString()));
            postOutputDTOS.add(new PostOutputDTO(Long.valueOf(object[0].toString()),object[1].toString(),object[3].toString(),object[2].toString(),commentOutputDTOS));
        }
        return postOutputDTOS;
    }


}

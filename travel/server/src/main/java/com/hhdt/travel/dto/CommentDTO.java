package com.fake.travel.dto;

import lombok.Data;

@Data
public class CommentDTO {

    private long id;

    private String content;

    private long idUser;

    private long idPost;
}

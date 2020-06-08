package com.fake.travel.dto;

import com.fake.travel.entity.Comment;

import java.util.List;

public class PostOutputDTO {
    private Long id;

    private String content;

    private String userName;

    private String image;

    private List<CommentOutputDTO> commentOutputDTOS;

    public PostOutputDTO() {
    }

    public PostOutputDTO(Long id, String content, String userName, String image) {
        this.id = id;
        this.content = content;
        this.userName = userName;
        this.image = image;
    }

    public PostOutputDTO(Long id, String content, String userName, String image, List<CommentOutputDTO> commentOutputDTOS) {
        this.id = id;
        this.content = content;
        this.userName = userName;
        this.image = image;
        this.commentOutputDTOS = commentOutputDTOS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<CommentOutputDTO> getCommentOutputDTOS() {
        return commentOutputDTOS;
    }

    public void setCommentOutputDTOS(List<CommentOutputDTO> commentOutputDTOS) {
        this.commentOutputDTOS = commentOutputDTOS;
    }
}

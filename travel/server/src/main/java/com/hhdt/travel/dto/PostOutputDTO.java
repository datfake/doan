package com.hhdt.travel.dto;

import java.util.List;

public class PostOutputDTO {
    private Long id;

    private String name;

    private String address;

    private String content;

    private String userName;

    private byte[] image;

    private List<CommentOutputDTO> commentOutputDTOS;

    public PostOutputDTO() {
    }

    public PostOutputDTO(Long id, String name, String address, String content, String userName, byte[] image) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.content = content;
        this.userName = userName;
        this.image = image;
    }

    public PostOutputDTO(Long id, String content, String userName, byte[] image, List<CommentOutputDTO> commentOutputDTOS) {
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<CommentOutputDTO> getCommentOutputDTOS() {
        return commentOutputDTOS;
    }

    public void setCommentOutputDTOS(List<CommentOutputDTO> commentOutputDTOS) {
        this.commentOutputDTOS = commentOutputDTOS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

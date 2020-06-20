package com.hhdt.travel.dto;

import lombok.Data;

@Data
public class CommentOutputDTO {

    public CommentOutputDTO() {
    }

    public CommentOutputDTO(long id, String content, String userName) {
        this.id = id;
        this.content = content;
        this.userName = userName;
    }

    private long id;

    private String content;

    private String userName;
}

package com.fake.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

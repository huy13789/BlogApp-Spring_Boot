package com.vti.blogapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDTO {
    private Long id;
    private String name;
    private String email;
    private String body;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}

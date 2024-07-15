package com.vti.blogapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostDto {
    private Long id;

    private String title;

    private String content;

    private String description;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;
}

package com.vti.blogapp.mapper;

import com.vti.blogapp.dto.CommentDTO;
import com.vti.blogapp.entity.Comment;
import com.vti.blogapp.form.CommentCreateFrom;
import com.vti.blogapp.form.CommentUpdateFrom;

public class CommentMapper {
    public static Comment map (CommentCreateFrom from){
        var cmt = new Comment();
        cmt.setName(from.getName());
        cmt.setEmail(from.getEmail());
        cmt.setBody(from.getBody());
        return cmt;
    }

    public static CommentDTO map(Comment comment){
        var dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setBody(comment.getBody());
        dto.setName(comment.getName());
        dto.setEmail(comment.getName());
        dto.setCreateAt(comment.getCreateAt());
        dto.setUpdateAt(comment.getUpdateAt());
        return dto;
    }

    public static void map(CommentUpdateFrom from, Comment comment){
        comment.setName(from.getName());
        comment.setEmail(from.getEmail());
        comment.setBody(from.getBody());
    }
}

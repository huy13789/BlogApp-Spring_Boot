package com.vti.blogapp.mapper;

import com.vti.blogapp.dto.PostDto;
import com.vti.blogapp.entity.Post;
import com.vti.blogapp.form.PostCreateForm;
import com.vti.blogapp.form.PostUpdateForm;

public class PostMapper {

    // Create new Post
    public static Post map(PostCreateForm form) {
        var post = new Post();
        post.setTitle(form.getTitle());
        post.setContent(form.getContent());
        post.setDescription(form.getDescription());
        post.setStatus(form.getStatus());
        return post;
    }

    // Update Post
    public static void map(PostUpdateForm postUpdateForm, Post post) {
        post.setTitle(postUpdateForm.getTitle());
        post.setContent(postUpdateForm.getContent());
        post.setDescription(postUpdateForm.getDescription());
        post.setStatus(postUpdateForm.getStatus());
    }

    // Data Transfer Object
    public static PostDto map(Post post) {
        var dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setDescription(post.getDescription());
        dto.setStatus(post.getStatus());
        dto.setCreateAt(post.getCreateAt());
        dto.setUpdateAt(post.getUpdateAt());
        return dto;
    }


}

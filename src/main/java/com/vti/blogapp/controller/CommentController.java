package com.vti.blogapp.controller;

import com.vti.blogapp.dto.CommentDTO;
import com.vti.blogapp.form.CommentCreateFrom;
import com.vti.blogapp.form.CommentUpdateFrom;
import com.vti.blogapp.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class CommentController {
    private CommentService commentService;

    @GetMapping("/api/v1/comments")
    public Page<CommentDTO> findAll(Pageable pageable) {
        return commentService.findAll(pageable);
    }

    @GetMapping("/api/v1/comments/{id}")
    public CommentDTO findById(@PathVariable("id") Long id) {
        return commentService.findById(id);
    }

    @GetMapping("/api/v1/posts/{post_id}/comments")
    public Page<CommentDTO> findByPostId(@PathVariable("post_id") Long id, Pageable pageable) {
        return commentService.findByPostId(id, pageable);
    }

    @PostMapping("/api/v1/posts/{post_id}/comments")
    public CommentDTO create(@PathVariable("post_id") Long post_id, @RequestBody CommentCreateFrom from) {
        return commentService.create(post_id, from);
    }

    @PostMapping("/api/v1/comments/{post_id}")
    public CommentDTO update(@PathVariable("post_id") Long post_id, @RequestBody CommentUpdateFrom from) {
        return commentService.update(post_id, from);
    }

    @DeleteMapping("/api/v1/comments/{id}")
    public void delete(@PathVariable Long id) {
        commentService.deleteByID(id);
    }

    @DeleteMapping("/api/v1/comments/email/{email}")
    public void deleteByEmail(@PathVariable("email") String mail) {
        commentService.deleteByEmail(mail);
    }

}

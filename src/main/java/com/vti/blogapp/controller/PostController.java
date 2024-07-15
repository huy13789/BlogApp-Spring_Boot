package com.vti.blogapp.controller;

import com.vti.blogapp.dto.PostDto;
import com.vti.blogapp.form.PostCreateForm;
import com.vti.blogapp.form.PostUpdateForm;
import com.vti.blogapp.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // = Controller + ResponseBody
@AllArgsConstructor
public class PostController {
    private PostService postService;

    @GetMapping("api/v1/posts")
    public List<PostDto> findAll() {
        return postService.findAll();
    }

    @GetMapping("api/v1/posts/{id}")
    public PostDto findById(@PathVariable("id") Long id) {
        return postService.findById(id);
    }

    @PostMapping("api/v1/posts")
    public PostDto create(@RequestBody PostCreateForm form) {
        return postService.create(form);
    }

    @PutMapping("api/v1/posts/{id}")
    public PostDto update(@PathVariable("id") Long id,
                          @RequestBody PostUpdateForm form) {
        return postService.update(id, form);
    }

    @DeleteMapping("api/v1/posts/{id}")
    public void deleteByI(@PathVariable("id") Long id) {
        postService.deleteById(id);
    }
}

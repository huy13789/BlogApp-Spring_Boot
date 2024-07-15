package com.vti.blogapp.service.impl;

import com.vti.blogapp.dto.PostDto;
import com.vti.blogapp.entity.Post;
import com.vti.blogapp.form.PostCreateForm;
import com.vti.blogapp.form.PostUpdateForm;
import com.vti.blogapp.mapper.PostMapper;
import com.vti.blogapp.respository.PostRepository;
import com.vti.blogapp.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    @Override
    public List<PostDto> findAll() {
        var posts = postRepository.findAll();
        var dtos = new ArrayList<PostDto>();
        for (Post post : posts) {
            var dto = PostMapper.map(post);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public PostDto findById(Long id) {
        // Cach 1
//        return postRepository.findById(id)
//                .map(new Function<Post, PostDto>() {
//                   @Override
//                   public PostDto apply(Post post1)
//                   {
//                       return PostMapper.map(post1);
//                   }
//                });

        //Cach 2
//        return postRepository.findById(id)
//                .map(post1 -> PostMapper.map(post1));

        return postRepository.findById(id)
                .map(PostMapper::map)
                .orElse(null);
    }

    @Override
    public PostDto create(PostCreateForm form) {
        var post = PostMapper.map(form);
        var savePost = postRepository.save(post);
        return PostMapper.map(savePost);
    }

    @Override
    public PostDto update(Long id, PostUpdateForm form) {
//        postRepository.findById(id)
//                .ifPresent(post -> {
//                    PostMapper.map(form,post);
//                    postRepository.save(post);
//                });
        var optional = postRepository.findById(id);
        if (optional.isEmpty()){
            return null;
        }
        var post = optional.get();
        PostMapper.map(form, post);
        var savepost = postRepository.save(post);
        return PostMapper.map(savepost);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}

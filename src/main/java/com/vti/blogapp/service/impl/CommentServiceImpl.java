package com.vti.blogapp.service.impl;

import com.vti.blogapp.dto.CommentDTO;
import com.vti.blogapp.entity.Comment;
import com.vti.blogapp.entity.Post;
import com.vti.blogapp.form.CommentCreateFrom;
import com.vti.blogapp.form.CommentUpdateFrom;
import com.vti.blogapp.mapper.CommentMapper;
import com.vti.blogapp.respository.CommentRepository;
import com.vti.blogapp.respository.PostRepository;
import com.vti.blogapp.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    private PostRepository postRepository;

    @Override
    public Page<CommentDTO> findAll(Pageable pageable) {
//        var cmt = commentRepository.findAll();
//        var dtos = new ArrayList<CommentDTO>();
//        for (Comment comment : cmt) {
//            var dto = CommentMapper.map(comment);
//            dtos.add(dto);
//        }
//        return dtos;
        return commentRepository.findAll(pageable)
                .map(CommentMapper :: map);
    }

    @Override
    public Page<CommentDTO> findByPostId(Long id, Pageable pageable) {
        return commentRepository.findByPostId(id, pageable)
                .map(CommentMapper::map);
    }

    @Override
    public CommentDTO findById(Long id) {
        return commentRepository.findById(id)
                .map(CommentMapper::map)
                .orElse(null);
    }

    @Override
    public CommentDTO create(Long post_id, CommentCreateFrom from) {
        var optional = postRepository.findById(post_id);

        if (optional.isEmpty())
            return null;

        var post = optional.get();

        var comment = CommentMapper.map(from);

        comment.setPost(post);

        var saveComment = commentRepository.save(comment);

        //var saveComment = commentRepository.save(CommentMapper.map(from));

        return CommentMapper.map(saveComment);
    }

    @Override
    public CommentDTO update(Long id, CommentUpdateFrom from) {
        var optional = commentRepository.findById(id);
        if (optional.isEmpty())
            return null;
        var cmt = optional.get();
        CommentMapper.map(from, cmt);
        var saveCmt = commentRepository.save(cmt);
        return CommentMapper.map(saveCmt);
    }

    @Override
    public void deleteByID(Long id) {
        commentRepository.deleteById(id);
    }
}

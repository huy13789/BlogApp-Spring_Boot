package com.vti.blogapp.service;

import com.vti.blogapp.dto.CommentDTO;
import com.vti.blogapp.entity.Comment;
import com.vti.blogapp.form.CommentCreateFrom;
import com.vti.blogapp.form.CommentUpdateFrom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    Page<CommentDTO> findAll(Pageable pageables);

    Page<CommentDTO> findByPostId(Long id, Pageable pageable);

    CommentDTO findById(Long id);

    CommentDTO create(Long post_id, CommentCreateFrom from);

    CommentDTO update(Long post_id, CommentUpdateFrom from);

    void deleteByID(Long id);

}

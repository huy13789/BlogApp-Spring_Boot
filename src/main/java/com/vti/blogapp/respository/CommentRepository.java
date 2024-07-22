package com.vti.blogapp.respository;

import com.vti.blogapp.dto.CommentDTO;
import com.vti.blogapp.entity.Comment;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    //1. Method name
    // Tiền tố: finBy, existBy, countBy, deleteBy
    // Lấy ra comment theo tên
    List<Comment> findByName(String name);

    List<Comment> findByBodyContaining(String search);

    List<Comment> findByNameOrEmail(String name, String mail);

    //Find all comment follow post_id
    Page<Comment> findByPostId(Long postId, Pageable pageable);

    //2. @Query
    // Name parameter - HQL

    @Query("DELETE from Comment WHERE email = :email")
    void DeleteByEmail(@Param("email") String email);

    @Query("DELETE from Comment WHERE email = ?1 AND email = ?2")
    void DeleteByNameAndEmail(@Param("email") String name, String email);

    //SQL
    @Query(value = "SELECT * FROM comment WHERE id > ?1", nativeQuery = true) //nativeQuery = true tức là ăn theo tên ở DB
    Page<CommentDTO> findByIdGreaterThan(Long id, Pageable pageable);


}

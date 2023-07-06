package com.server.abm.repository;

import com.server.abm.entity.Comment;
import com.server.abm.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    List<Comment> findCommentByMusic(Music music);
    Comment findCommentById(int id);
}

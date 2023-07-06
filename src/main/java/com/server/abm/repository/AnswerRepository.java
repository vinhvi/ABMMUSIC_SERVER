package com.server.abm.repository;

import com.server.abm.entity.Answer;
import com.server.abm.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer,Integer> {
    List<Answer> findAnswerByComment(Comment comment);

    Answer findAnswerById(int id);
}

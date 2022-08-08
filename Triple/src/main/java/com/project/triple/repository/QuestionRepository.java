package com.project.triple.repository;

import com.project.triple.model.entity.QnA.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    Optional<Question> findByUserId(Long idx);

    List<Question> findAllByUserIdOrderByIdxDesc(Long userId);

}

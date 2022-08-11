package com.project.triple.repository;

import com.project.triple.model.entity.Mysave;
import com.project.triple.model.entity.QnA.Question;
import com.project.triple.model.entity.Review;
import com.project.triple.model.enumclass.SaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MysaveRepository extends JpaRepository<Mysave, Long> {
//    List<Mysave> findByUserId(Long userId);
//
//    Mysave findByIdx(Long idx);

    List<Mysave> findAllBySaveTypeAndUserId(SaveType saveType, Long userId);

    List<Mysave> findAllByUserIdOrderByIdxDesc(Long userId);
}

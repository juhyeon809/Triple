package com.project.triple.repository;

import com.project.triple.model.entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Long> {
    Faq findByIdx(Long idx);
}

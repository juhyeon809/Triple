package com.project.triple.repository;

import com.project.triple.model.entity.Faq;
import com.project.triple.model.enumclass.FaqCategory;
import com.project.triple.model.entity.User.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FaqRepository extends JpaRepository<Faq, Long> {
    Faq findByIdx(Long idx);

    List<Faq> findByFaqCategory(FaqCategory faqCategory);
    List<Faq> findAllByOrderByIdxDesc();
}

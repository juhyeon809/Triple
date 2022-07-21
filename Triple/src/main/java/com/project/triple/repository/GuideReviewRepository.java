package com.project.triple.repository;

import com.project.triple.model.entity.Guide.GuideReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideReviewRepository extends JpaRepository<GuideReview, Long> {
}

package com.project.triple.repository;

import com.project.triple.model.entity.Guide.GuideReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuideReviewRepository extends JpaRepository<GuideReview, Long> {

    List<GuideReview> findAllByPostId(Long postId) ;


}

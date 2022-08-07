package com.project.triple.repository;

import com.project.triple.model.entity.Spot.SpotReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpotReviewRepository extends JpaRepository<SpotReview, Long> {

    List<SpotReview> findAllByPostId(Long postId) ;
}

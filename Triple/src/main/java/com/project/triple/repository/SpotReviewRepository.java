package com.project.triple.repository;

import com.project.triple.model.entity.Guide.GuideReview;
import com.project.triple.model.entity.Spot.SpotReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpotReviewRepository extends JpaRepository<SpotReview, Long> {

    List<SpotReview> findAllByPostId(Long postId) ;

    List<SpotReview> findAllByUserEmail(String email);

    Optional<SpotReview> findByUserEmail(String email);
}

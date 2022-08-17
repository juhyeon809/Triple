package com.project.triple.repository;

import com.project.triple.model.entity.Guide.GuideReview;
import com.project.triple.model.entity.Restaurant.RestaurantReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantReviewRepository extends JpaRepository<RestaurantReview, Long> {

    List<RestaurantReview> findAllByPostId(Long postId) ;

    List<RestaurantReview> findAllByUserEmail(String email);

    Optional<RestaurantReview> findByUserEmail(String email);
}

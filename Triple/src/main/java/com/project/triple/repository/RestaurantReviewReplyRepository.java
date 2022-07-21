package com.project.triple.repository;


import com.project.triple.model.entity.Restaurant.RestaurantReviewReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantReviewReplyRepository extends JpaRepository<RestaurantReviewReply, Long> {
}

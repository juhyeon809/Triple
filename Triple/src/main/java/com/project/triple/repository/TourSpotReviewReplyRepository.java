package com.project.triple.repository;

import com.project.triple.model.entity.TourSpotReviewReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourSpotReviewReplyRepository extends JpaRepository<TourSpotReviewReply, Long> {
}

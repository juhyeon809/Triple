package com.project.triple.repository;

import com.project.triple.model.entity.Guide.GuideReviewReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuideReviewReplyRepository extends JpaRepository<GuideReviewReply, Long> {
}

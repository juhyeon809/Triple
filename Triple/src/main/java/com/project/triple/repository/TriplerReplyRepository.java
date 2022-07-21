package com.project.triple.repository;

import com.project.triple.model.entity.Tirpler.TriplerReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TriplerReplyRepository extends JpaRepository<TriplerReply, Long> {
}

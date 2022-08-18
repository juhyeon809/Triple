package com.project.triple.repository;

import com.project.triple.model.entity.Event;
import com.project.triple.model.entity.Notice;
import com.project.triple.model.entity.User.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Event findByIdx(Long idx);

    List<Event> findAllByOrderByIdxDesc();
}

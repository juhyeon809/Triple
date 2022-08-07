package com.project.triple.repository;

import com.project.triple.model.entity.Event;
import com.project.triple.model.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    Notice findByIdx(Long idx);

}

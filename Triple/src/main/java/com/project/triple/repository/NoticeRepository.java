package com.project.triple.repository;

import com.project.triple.model.entity.Magazine;
import com.project.triple.model.entity.Notice;
import com.project.triple.model.entity.User.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    Notice findByIdx(Long idx);

    List<Notice> findAllByOrderByIdxDesc();
}

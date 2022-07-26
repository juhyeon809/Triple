package com.project.triple.repository;

import com.project.triple.model.entity.Mysave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MysaveRepository extends JpaRepository<Mysave, Long> {
}

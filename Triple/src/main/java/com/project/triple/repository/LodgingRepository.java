package com.project.triple.repository;

import com.project.triple.model.entity.Lodging;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LodgingRepository extends JpaRepository<Lodging, Long> {

}

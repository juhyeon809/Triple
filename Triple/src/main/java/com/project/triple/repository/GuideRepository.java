package com.project.triple.repository;

import com.project.triple.model.entity.Guide.Guide;
import com.project.triple.model.enumclass.GuideType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuideRepository extends JpaRepository<Guide, Long> {

//    List<Guide> findAllByType(GuideType type);
}

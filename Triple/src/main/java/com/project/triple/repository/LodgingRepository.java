package com.project.triple.repository;

import com.project.triple.model.entity.Coupon.Coupon;
import com.project.triple.model.entity.Guide.Guide;
import com.project.triple.model.entity.Lodging.Lodging;
import com.project.triple.model.entity.Lodging.LodgingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LodgingRepository extends JpaRepository<Lodging, Long> {

//    List<Lodging> findByIdx(Long lodgingId);

    Lodging findByIdx(Long idx);
    List<Lodging> findAllByOrderByIdxDesc();

}

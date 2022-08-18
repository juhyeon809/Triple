package com.project.triple.repository;

import com.project.triple.model.entity.Lodging.Lodging;
import com.project.triple.model.entity.Lodging.LodgingRoom;
import com.project.triple.model.enumclass.LodgingRoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LodgingRoomRepository extends JpaRepository<LodgingRoom, Long> {
    LodgingRoom findByRoomNum(String roomNum);


    List<LodgingRoom> findAllByStatus(LodgingRoomStatus status);

    List<LodgingRoom> findAllByCompanyId(Long companyId);
    List<LodgingRoom> findAllByOrderByIdxDesc();

}

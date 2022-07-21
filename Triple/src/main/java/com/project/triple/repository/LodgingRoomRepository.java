package com.project.triple.repository;

import com.project.triple.model.entity.Lodging.LodgingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LodgingRoomRepository extends JpaRepository<LodgingRoom, Long> {

}

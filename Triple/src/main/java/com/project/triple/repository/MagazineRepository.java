package com.project.triple.repository;

import com.project.triple.model.entity.Magazine;
import com.project.triple.model.entity.User.Users;
import com.project.triple.model.enumclass.MagazineType;
import com.project.triple.model.network.response.MagazineApiResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MagazineRepository extends JpaRepository<Magazine, Long> {

    List<Magazine> findAllByMagazineType(MagazineType magazineType);

    Magazine findByIdx(Long idx);

    List<Magazine> findAllByOrderByIdxDesc();
}

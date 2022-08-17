package com.project.triple.repository;

import com.project.triple.model.entity.Guide.Guide;
import com.project.triple.model.entity.Restaurant.Restaurant;
import com.project.triple.model.entity.Spot.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Restaurant findByIdx(Long postId);

    List<Restaurant> findAllByOrderByIdxDesc();
}

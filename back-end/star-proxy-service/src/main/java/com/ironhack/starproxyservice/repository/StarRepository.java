package com.ironhack.starproxyservice.repository;

import com.ironhack.starproxyservice.controller.dto.StarDTO;
import com.ironhack.starproxyservice.model.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {
    List<Star> findByConstellation(String constellation);
}

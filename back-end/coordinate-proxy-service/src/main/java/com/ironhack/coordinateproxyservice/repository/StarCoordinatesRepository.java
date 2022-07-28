package com.ironhack.coordinateproxyservice.repository;

import com.ironhack.coordinateproxyservice.model.StarCoordinates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarCoordinatesRepository extends JpaRepository <StarCoordinates, Long> {
}

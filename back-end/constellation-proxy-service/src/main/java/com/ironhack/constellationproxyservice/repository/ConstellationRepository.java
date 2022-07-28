package com.ironhack.constellationproxyservice.repository;

import com.ironhack.constellationproxyservice.model.Constellation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConstellationRepository extends JpaRepository<Constellation, Long> {
}

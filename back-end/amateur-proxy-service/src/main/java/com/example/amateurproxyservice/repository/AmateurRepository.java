package com.example.amateurproxyservice.repository;

import com.example.amateurproxyservice.model.Amateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Optional;

@Repository
public interface AmateurRepository extends JpaRepository<Amateur, Long> {
    Optional<Amateur> findByName(String name);

}

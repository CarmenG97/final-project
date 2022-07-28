package com.example.eventproxyservice.repository;

import com.example.eventproxyservice.model.AmateurAttendEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmateurAttendEventRepository extends JpaRepository<AmateurAttendEvent, Long> {
}

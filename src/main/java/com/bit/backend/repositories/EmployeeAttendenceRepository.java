package com.bit.backend.repositories;

import com.bit.backend.entities.EmployeeAttendenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface EmployeeAttendenceRepository extends JpaRepository<EmployeeAttendenceEntity, Long> {
    EmployeeAttendenceEntity findByUsersAndAttandenceDate(String users, LocalDate now);
}

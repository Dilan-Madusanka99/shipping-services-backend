package com.bit.backend.repositories;

import com.bit.backend.entities.EmployeeAttendenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeAttendenceRepository extends JpaRepository<EmployeeAttendenceEntity, Long> {
}

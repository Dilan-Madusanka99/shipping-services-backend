package com.bit.backend.repositories;

import com.bit.backend.entities.AppointmentEntity;
import com.bit.backend.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<AppointmentEntity, Long> {


}

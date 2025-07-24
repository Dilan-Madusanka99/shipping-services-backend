package com.bit.backend.repositories;

import com.bit.backend.entities.EmployeeAttendenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface EmployeeAttendenceRepository extends JpaRepository<EmployeeAttendenceEntity, Long> {
    EmployeeAttendenceEntity findByUsersAndAttandenceDate(String users, LocalDate now);

    @Query(nativeQuery = true, value = "select DATE_FORMAT(attandence_Date, '%Y-%m') as month, count(*) as cnt from ems.employee_attendence group by month order by month")
    List<Map<String, Object>> getEmployeeAttendanceByMonth();
}

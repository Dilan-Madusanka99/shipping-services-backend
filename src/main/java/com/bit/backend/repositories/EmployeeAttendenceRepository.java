package com.bit.backend.repositories;

import com.bit.backend.entities.EmployeeAttendenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface EmployeeAttendenceRepository extends JpaRepository<EmployeeAttendenceEntity, Long> {

    EmployeeAttendenceEntity findByUsersAndAttandenceDate(String users, LocalDate now);

    @Query(nativeQuery = true, value =
            "SELECT CONCAT(e.first_name, ' ', e.last_name) AS employeeName, " +
                    "COUNT(CASE WHEN a.attendence_Status = 'Present' THEN 1 END) AS cnt " +
                    "FROM ems.employee_attendence a " +
                    "JOIN ems.employee e ON a.users = e.id " +
                    "WHERE MONTH(a.attandence_Date) = :month " +
                    "AND YEAR(a.attandence_Date) = :year " +
                    "GROUP BY e.first_name, e.last_name " +
                    "ORDER BY cnt DESC")
    List<Map<String, Object>> getEmployeeAttendanceByEmployee(@Param("month") int month, @Param("year") int year);

    boolean existsByUsersAndAttandenceDate(String id, LocalDate today);
}

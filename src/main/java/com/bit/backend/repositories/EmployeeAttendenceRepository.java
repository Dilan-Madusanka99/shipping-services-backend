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
            "select CONCAT(e.first_name,' ',e.last_name) as employeeName, count(*) as cnt " +
                    "from ems.employee_attendence a " +
                    "join ems.employee e on a.users = e.id " +
                    "where DATE_FORMAT(a.attandence_Date, '%Y-%m') = :month " +
                    "group by e.first_name, e.last_name " +
                    "order by cnt")
    List<Map<String, Object>> getEmployeeAttendanceByEmployee(@Param("month") String month);

    boolean existsByUsersAndAttandenceDate(String id, LocalDate today);
}

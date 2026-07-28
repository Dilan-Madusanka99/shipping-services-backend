package com.bit.backend.repositories;

import com.bit.backend.entities.EmployeeAttendenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface EmployeeAttendenceRepository extends JpaRepository<EmployeeAttendenceEntity, Long> {

    EmployeeAttendenceEntity findByUsersAndAttandenceDate(String users, LocalDate now);

    @Query(nativeQuery = true, value =
            "select concat(e.first_name, ' ', e.last_name) as employeeName, " +
                    "count(*) as cnt " +
                    "from ems.employee_attendence ea " +
                    "inner join ems.employee e on e.id = ea.users " +
                    "group by e.first_name, e.last_name " +
                    "order by employeeName")
    List<Map<String, Object>> getEmployeeAttendanceByEmployee();

    boolean existsByUsersAndAttandenceDate(String id, LocalDate today);
}

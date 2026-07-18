package com.bit.backend.schedulers;

import com.bit.backend.entities.EmployeeAttendenceEntity;
import com.bit.backend.entities.EmployeeEntity;
import com.bit.backend.repositories.EmployeeAttendenceRepository;
import com.bit.backend.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Component
@RequiredArgsConstructor
@Transactional
public class AttendanceScheduler {
    private final EmployeeAttendenceRepository employeeAttendenceRepository;
    private final EmployeeRepository employeeRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void runOnStartup() {
        markDailyAttendance();
    }

    @Scheduled(cron = "${attendance.cron:0 0 6 * * *}", zone = "Asia/Colombo")
    public void markDailyAttendance() {
        LocalDate today = LocalDate.now(ZoneId.of("Asia/Colombo"));
        DayOfWeek day = today.getDayOfWeek();

        boolean isWeekend = (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY);
        String status = isWeekend ? "Absent" : "Present";

        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();

        for (EmployeeEntity employeeEntity : employeeEntityList) {
            if (!employeeAttendenceRepository.existsByUsersAndAttandenceDate(employeeEntity.getId().toString(), today)) {
                EmployeeAttendenceEntity employeeAttendenceEntity = new EmployeeAttendenceEntity();
                employeeAttendenceEntity.setAttandenceDate(today);
                employeeAttendenceEntity.setAttendenceStatus(status);
                employeeAttendenceEntity.setRoles(employeeEntity.getRoles());
                employeeAttendenceEntity.setUsers(employeeEntity.getId().toString());
                employeeAttendenceEntity.setUserName(employeeEntity.getCallingName());
                employeeAttendenceRepository.save(employeeAttendenceEntity);
            }
        }
    }
}

package com.bit.backend.services.impl;

import com.bit.backend.dtos.EmployeeAttendenceDto;

import java.util.List;

public interface EmployeeAttendenceServiceI {

    EmployeeAttendenceDto addEmployeeAttendenceEntity(EmployeeAttendenceDto employeeAttendenceDto);
    List<EmployeeAttendenceDto> getData();
    EmployeeAttendenceDto updateEmployeeAttendence(long id, EmployeeAttendenceDto employeeAttendenceDto);
    EmployeeAttendenceDto deleteEmployeeAttendence(long id);
}

package com.bit.backend.controllers;

import com.bit.backend.dtos.EmployeeAttendenceDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.impl.EmployeeAttendenceServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeAttendenceController {

    private final EmployeeAttendenceServiceI employeeAttendenceServiceI;

    public EmployeeAttendenceController(EmployeeAttendenceServiceI employeeAttendenceServiceI) {
        this.employeeAttendenceServiceI = employeeAttendenceServiceI;
    }

    @PostMapping("/employeeAttendence")
    public ResponseEntity<EmployeeAttendenceDto> addEmployeeAttendence(@RequestBody EmployeeAttendenceDto employeeAttendenceDto) {

        try {
            EmployeeAttendenceDto employeeAttendenceDtoResponse = employeeAttendenceServiceI.addEmployeeAttendenceEntity(employeeAttendenceDto);
            return ResponseEntity.created(URI.create("/employeeAttendence"+employeeAttendenceDtoResponse.getId())).body(employeeAttendenceDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employeeAttendence")
    public ResponseEntity<List<EmployeeAttendenceDto>> getData() {

        try {
            List<EmployeeAttendenceDto> employeeAttendenceDtoList = employeeAttendenceServiceI.getData();
            return ResponseEntity.ok(employeeAttendenceDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employeeAttendence/{id}")
    public ResponseEntity<EmployeeAttendenceDto> updateEmployeeAttendence(@PathVariable Long id, @RequestBody EmployeeAttendenceDto employeeAttendenceDto) {

        try {
            EmployeeAttendenceDto responseEmployeeAttendenceDto = employeeAttendenceServiceI.updateEmployeeAttendence(id, employeeAttendenceDto);
            return ResponseEntity.ok(responseEmployeeAttendenceDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/employeeAttendence/{id}")
    public ResponseEntity<EmployeeAttendenceDto> deleteEmployeeAttendence(@PathVariable Long id) {

        try {
            EmployeeAttendenceDto employeeAttendenceDto = employeeAttendenceServiceI.deleteEmployeeAttendence(id);
            return ResponseEntity.ok(employeeAttendenceDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

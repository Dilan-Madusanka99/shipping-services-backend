package com.bit.backend.controllers;


import com.bit.backend.dtos.EmployeeDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.impl.EmployeeServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeServiceI employeeServiceI;

    public EmployeeController(EmployeeServiceI employeeServiceI) {this.employeeServiceI = employeeServiceI;}

    @PostMapping("/employee")
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {

        try {
            EmployeeDto employeeDtoResponse = employeeServiceI.addEmployeeEntity(employeeDto);
            return ResponseEntity.created(URI.create("/employee"+employeeDtoResponse.getFirstName())).body(employeeDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeDto>> getData() {

        try {
            List<EmployeeDto> employeeDtoList = employeeServiceI.getData();
            return ResponseEntity.ok(employeeDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeDto) {

        try {
            EmployeeDto responseEmployeeDto = employeeServiceI.updateEmployee(id, employeeDto);
            return ResponseEntity.ok(responseEmployeeDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable Long id) {

        try {
            EmployeeDto employeeDto = employeeServiceI.deleteEmployee(id);
            return ResponseEntity.ok(employeeDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

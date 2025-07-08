package com.bit.backend.controllers;


import com.bit.backend.dtos.EmployeeDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.impl.EmployeeServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeServiceI employeeServiceI;

    public EmployeeController(EmployeeServiceI employeeServiceI) {
        this.employeeServiceI = employeeServiceI;}

    @PostMapping(value = {"/employee"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<EmployeeDto> addEmployee(@RequestPart ("employeeForm") EmployeeDto employeeDto,
                                                   @RequestPart("profileImage") MultipartFile file) {

        try {
            employeeDto.setProfileImage(file.getBytes());
            employeeDto.setProfileImageName(file.getOriginalFilename());
            employeeDto.setProfileImageType(file.getContentType());
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

// changes for edit - putMapping
    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id,
                                                      @RequestPart ("employeeForm") EmployeeDto employeeDto,
                                                      @RequestPart(value = "profileImage", required = false) MultipartFile file) {

        try {
            if (file != null && !file.isEmpty()) {
                employeeDto.setProfileImage(file.getBytes());
                employeeDto.setProfileImageName(file.getOriginalFilename());
                employeeDto.setProfileImageType(file.getContentType());
            }
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

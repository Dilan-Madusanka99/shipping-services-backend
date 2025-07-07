package com.bit.backend.controllers;

import com.bit.backend.dtos.SupplierRegistrationDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.impl.SupplierRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
public class SupplierRegistrationController {

    private final SupplierRegistrationServiceI supplierRegistrationServiceI;

    public SupplierRegistrationController(SupplierRegistrationServiceI supplierRegistrationServiceI) {
        this.supplierRegistrationServiceI = supplierRegistrationServiceI;
    }

    @PostMapping(value = {"/supplier_Registration"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<SupplierRegistrationDto> addSupplierRegistration(@RequestPart("supplier RegistrationForm") SupplierRegistrationDto supplierRegistrationDto, @RequestPart("profileImage") MultipartFile file) {

        try {
            supplierRegistrationDto.setProfileImage(file.getBytes());
            supplierRegistrationDto.setProfileImageName(file.getOriginalFilename());
            supplierRegistrationDto.setProfileImageType(file.getContentType());
            SupplierRegistrationDto supplierRegistrationDtoResponse = supplierRegistrationServiceI.addSupplierRegistrationEntity(supplierRegistrationDto);
            return ResponseEntity.created(URI.create("/supplier_Registration"+supplierRegistrationDtoResponse.getSupplierNo())).body(supplierRegistrationDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/supplier_Registration")
    public ResponseEntity<List<SupplierRegistrationDto>> getData() {

        try {
            List<SupplierRegistrationDto> supplierRegistrationDtoList = supplierRegistrationServiceI.getData();
            return ResponseEntity.ok(supplierRegistrationDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/supplier_Registration/{id}")
    public ResponseEntity<SupplierRegistrationDto> updateSupplierRegistration(@PathVariable Long id, @RequestBody SupplierRegistrationDto supplierRegistrationDto) {

        try {
            SupplierRegistrationDto responseSupplierRegistrationDto = supplierRegistrationServiceI.updateSupplierRegistration(id, supplierRegistrationDto);
            return ResponseEntity.ok(responseSupplierRegistrationDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/supplier_Registration/{id}")
    public ResponseEntity<SupplierRegistrationDto> deleteSupplierRegistration(@PathVariable Long id) {

        try {
            SupplierRegistrationDto supplierRegistrationDto = supplierRegistrationServiceI.deleteSupplierRegistration(id);
            return ResponseEntity.ok(supplierRegistrationDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.bit.backend.controllers;

import com.bit.backend.dtos.OtherDetailsRegistrationDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.impl.OtherDetailsRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class OtherDetailsRegistrationController {

    private final OtherDetailsRegistrationServiceI otherDetailsRegistrationServiceI;

    public OtherDetailsRegistrationController(OtherDetailsRegistrationServiceI otherDetailsRegistrationServiceI) {this.otherDetailsRegistrationServiceI = otherDetailsRegistrationServiceI;}

    @PostMapping("/other_details_registration")
    public ResponseEntity<OtherDetailsRegistrationDto> addOtherDetailsRegistration(@RequestBody OtherDetailsRegistrationDto otherDetailsRegistrationDto) {

        try {
            OtherDetailsRegistrationDto otherDetailsRegistrationDtoResponse = otherDetailsRegistrationServiceI.addOtherDetailsRegistrationEntity(otherDetailsRegistrationDto);
            return ResponseEntity.created(URI.create("/other_details_registration"+otherDetailsRegistrationDtoResponse.getSidNo())).body(otherDetailsRegistrationDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/other_details_registration")
    public ResponseEntity<List<OtherDetailsRegistrationDto>> getData() {

        try {
            List<OtherDetailsRegistrationDto> otherDetailsRegistrationDtoList = otherDetailsRegistrationServiceI.getData();
            return ResponseEntity.ok(otherDetailsRegistrationDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/other_details_registration/{id}")
    public ResponseEntity<OtherDetailsRegistrationDto> updateOtherDetailsRegistration(@PathVariable Long id, @RequestBody OtherDetailsRegistrationDto otherDetailsRegistrationDto) {

        try {
            OtherDetailsRegistrationDto responseOtherDetailsRegistrationDto = otherDetailsRegistrationServiceI.updateOtherDetailsRegistration(id, otherDetailsRegistrationDto);
            return ResponseEntity.ok(responseOtherDetailsRegistrationDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/other_details_registration/{id}")
    public ResponseEntity<OtherDetailsRegistrationDto> deleteOtherDetailsRegistration(@PathVariable Long id) {

        try {
            OtherDetailsRegistrationDto otherDetailsRegistrationDto = otherDetailsRegistrationServiceI.deleteOtherDetailsRegistration(id);
            return ResponseEntity.ok(otherDetailsRegistrationDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

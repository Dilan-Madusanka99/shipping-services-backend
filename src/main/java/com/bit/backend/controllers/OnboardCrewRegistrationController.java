package com.bit.backend.controllers;

import com.bit.backend.dtos.OnboardCrewRegistrationDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.impl.OnboardCrewRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class OnboardCrewRegistrationController {

    private final OnboardCrewRegistrationServiceI onboardCrewRegistrationServiceI;

    public OnboardCrewRegistrationController(OnboardCrewRegistrationServiceI onboardCrewRegistrationServiceI) {
        this.onboardCrewRegistrationServiceI = onboardCrewRegistrationServiceI;
    }

    @PostMapping("/onboardCrewRegistration")
    public ResponseEntity<OnboardCrewRegistrationDto> addOnboardCrewRegistration(@RequestBody OnboardCrewRegistrationDto onboardCrewRegistrationDto) {

        try {
            OnboardCrewRegistrationDto onboardCrewRegistrationDtoResponse = onboardCrewRegistrationServiceI.addOnboardCrewRegistrationEntity(onboardCrewRegistrationDto);
            return ResponseEntity.created(URI.create("/onboardCrewRegistration"+onboardCrewRegistrationDtoResponse.getSidNo())).body(onboardCrewRegistrationDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/onboardCrewRegistration")
    public ResponseEntity<List<OnboardCrewRegistrationDto>> getData() {

        try {
            List<OnboardCrewRegistrationDto> onboardCrewRegistrationDtoList = onboardCrewRegistrationServiceI.getData();
            return ResponseEntity.ok(onboardCrewRegistrationDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/onboardCrewRegistration/{id}")
    public ResponseEntity<OnboardCrewRegistrationDto> updateOnboardCrewRegistration(@PathVariable Long id, @RequestBody OnboardCrewRegistrationDto onboardCrewRegistrationDto) {

        try {
            OnboardCrewRegistrationDto responseOnboardCrewRegistrationDto = onboardCrewRegistrationServiceI.updateOnboardCrewRegistration(id, onboardCrewRegistrationDto);
            return ResponseEntity.ok(responseOnboardCrewRegistrationDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/onboardCrewRegistration/{id}")
    public ResponseEntity<OnboardCrewRegistrationDto> deleteOnboardCrewRegistration(@PathVariable Long id) {

        try {
            OnboardCrewRegistrationDto onboardCrewRegistrationDto = onboardCrewRegistrationServiceI.deleteOnboardCrewRegistration(id);
            return ResponseEntity.ok(onboardCrewRegistrationDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

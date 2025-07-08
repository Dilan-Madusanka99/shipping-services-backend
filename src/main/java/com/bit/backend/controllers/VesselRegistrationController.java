package com.bit.backend.controllers;

import com.bit.backend.dtos.VesselRegistrationDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.impl.VesselRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
public class VesselRegistrationController {

    private final VesselRegistrationServiceI vesselRegistrationServiceI;

    public VesselRegistrationController(VesselRegistrationServiceI vesselRegistrationServiceI) {
        this.vesselRegistrationServiceI = vesselRegistrationServiceI;
    }

    @PostMapping(value = {"/vessel_Registration"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<VesselRegistrationDto> addVesselRegistration(@RequestPart ("vesselRegistrationForm") VesselRegistrationDto vesselRegistrationDto, @RequestPart("profileImage") MultipartFile file) {

        try {
            vesselRegistrationDto.setProfileImage(file.getBytes());
            vesselRegistrationDto.setProfileImageName(file.getOriginalFilename());
            vesselRegistrationDto.setProfileImageType(file.getContentType());
            VesselRegistrationDto vesselRegistrationDtoResponse = vesselRegistrationServiceI.addVesselRegistrationEntity(vesselRegistrationDto);
            return ResponseEntity.created(URI.create("/vessel_Registration"+vesselRegistrationDtoResponse.getImoNo())).body(vesselRegistrationDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/vessel_Registration")
    public ResponseEntity<List<VesselRegistrationDto>> getData() {

        try {
            List<VesselRegistrationDto> vesselRegistrationDtoList = vesselRegistrationServiceI.getData();
            return ResponseEntity.ok(vesselRegistrationDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/vessel_Registration/{id}")
    public ResponseEntity<VesselRegistrationDto> updateVesselRegistration(@PathVariable Long id, @RequestPart ("vesselRegistrationForm") VesselRegistrationDto vesselRegistrationDto, @RequestPart("profileImage") MultipartFile file) {

        try {
            vesselRegistrationDto.setProfileImage(file.getBytes());
            vesselRegistrationDto.setProfileImageName(file.getOriginalFilename());
            vesselRegistrationDto.setProfileImageType(file.getContentType());
            VesselRegistrationDto responseVesselRegistrationDto = vesselRegistrationServiceI.updateVesselRegistration(id, vesselRegistrationDto);
            return ResponseEntity.ok(responseVesselRegistrationDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/vessel_Registration/{id}")
    public ResponseEntity<VesselRegistrationDto> deleteVesselRegistration(@PathVariable Long id) {

        try {
            VesselRegistrationDto vesselRegistrationDto = vesselRegistrationServiceI.deleteVesselRegistration(id);
            return ResponseEntity.ok(vesselRegistrationDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.bit.backend.controllers;

import com.bit.backend.dtos.CertificatesRegistrationDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.impl.CertificatesRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
public class CertificatesRegistrationController {

    private final CertificatesRegistrationServiceI certificatesRegistrationServiceI;

    public CertificatesRegistrationController(CertificatesRegistrationServiceI certificatesRegistrationServiceI) {this.certificatesRegistrationServiceI = certificatesRegistrationServiceI;}

    @PostMapping(value = {"/certificates_registration"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<CertificatesRegistrationDto> addCertificatesRegistration(@RequestPart("certificatesRegistrationForm") CertificatesRegistrationDto certificatesRegistrationDto, @RequestPart("certificateImage") MultipartFile file) {

        try {
            certificatesRegistrationDto.setCertificateImage(file.getBytes());
            certificatesRegistrationDto.setCertificateImageName(file.getOriginalFilename());
            certificatesRegistrationDto.setCertificateImageType(file.getContentType());
            CertificatesRegistrationDto certificatesRegistrationDtoResponse = certificatesRegistrationServiceI.addCertificatesRegistrationEntity(certificatesRegistrationDto);
            return ResponseEntity.created(URI.create("/certificates_registration"+certificatesRegistrationDtoResponse.getSidNo())).body(certificatesRegistrationDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/certificates_registration")
    public ResponseEntity<List<CertificatesRegistrationDto>> getData() {

        try {
            List<CertificatesRegistrationDto> certificatesRegistrationDtoList = certificatesRegistrationServiceI.getData();
            return ResponseEntity.ok(certificatesRegistrationDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/certificates_registration/{id}")
    public ResponseEntity<CertificatesRegistrationDto> updateCertificatesRegistration(@PathVariable Long id, @RequestBody CertificatesRegistrationDto certificatesRegistrationDto) {

        try {
            CertificatesRegistrationDto responseCertificatesRegistrationDto = certificatesRegistrationServiceI.updateCertificatesRegistration(id, certificatesRegistrationDto);
            return ResponseEntity.ok(responseCertificatesRegistrationDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/certificates_registration/{id}")
    public ResponseEntity<CertificatesRegistrationDto> deleteCertificatesRegistration(@PathVariable Long id) {

        try {
            CertificatesRegistrationDto certificatesRegistrationDto = certificatesRegistrationServiceI.deleteCertificatesRegistration(id);
            return ResponseEntity.ok(certificatesRegistrationDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

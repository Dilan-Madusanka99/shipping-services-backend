package com.bit.backend.controllers;

import com.bit.backend.dtos.CertificateVerificationDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.impl.CertificateVerificationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;
import java.util.List;

@RestController
public class CertificateVerificationController {

    private final CertificateVerificationServiceI certificateVerificationServiceI;

    public CertificateVerificationController(CertificateVerificationServiceI certificateVerificationServiceI) {
        this.certificateVerificationServiceI = certificateVerificationServiceI;
    }

    @PostMapping(value = {"/certificate_Verification"}, consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<CertificateVerificationDto> addCertificateVerification(@RequestPart("certificateVerificationForm") CertificateVerificationDto certificateVerificationDto,
                                                                                 @RequestPart("profileImage") MultipartFile file) {

        try {
            certificateVerificationDto.setProfileImage(file.getBytes());
            certificateVerificationDto.setProfileImageName(file.getOriginalFilename());
            certificateVerificationDto.setProfileImageType(file.getContentType());
            CertificateVerificationDto certificateVerificationDtoResponse = certificateVerificationServiceI.addCertificateVerificationEntity(certificateVerificationDto);
            return ResponseEntity.created(URI.create("/certificate_Verification"+certificateVerificationDtoResponse.getSidNo())).body(certificateVerificationDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/certificate_Verification")
    public ResponseEntity<List<CertificateVerificationDto>> getData() {

        try {
            List<CertificateVerificationDto> certificateVerificationDtoList = certificateVerificationServiceI.getData();
            return ResponseEntity.ok(certificateVerificationDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/certificate_Verification/{id}")
    public ResponseEntity<CertificateVerificationDto> updateCertificateVerification(@PathVariable Long id,
                                                      @RequestPart ("certificateVerificationForm") CertificateVerificationDto certificateVerificationDto,
                                                      @RequestPart(value = "profileImage", required = false) MultipartFile file) {

        try {
            if (file != null && !file.isEmpty()) {
                certificateVerificationDto.setProfileImage(file.getBytes());
                certificateVerificationDto.setProfileImageName(file.getOriginalFilename());
                certificateVerificationDto.setProfileImageType(file.getContentType());
            }
            CertificateVerificationDto responseCertificateVerificationDto = certificateVerificationServiceI.updateCertificateVerification(id, certificateVerificationDto);
            return ResponseEntity.ok(responseCertificateVerificationDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/certificate_Verification/{id}")
    public ResponseEntity<CertificateVerificationDto> deleteCertificateVerification(@PathVariable Long id) {

        try {
            CertificateVerificationDto certificateVerificationDto = certificateVerificationServiceI.deleteCertificateVerification(id);
            return ResponseEntity.ok(certificateVerificationDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

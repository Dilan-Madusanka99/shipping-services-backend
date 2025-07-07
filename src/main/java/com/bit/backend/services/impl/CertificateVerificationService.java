package com.bit.backend.services.impl;

import com.bit.backend.dtos.CertificateVerificationDto;
import com.bit.backend.entities.CertificateVerificationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.CertificateVerificationMapper;
import com.bit.backend.repositories.CertificateVerificationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificateVerificationService implements CertificateVerificationServiceI {

    private final CertificateVerificationRepository certificateVerificationRepository;
    private final CertificateVerificationMapper certificateVerificationMapper;

    public CertificateVerificationService(CertificateVerificationRepository certificateVerificationRepository, CertificateVerificationMapper certificateVerificationMapper) {
        this.certificateVerificationRepository = certificateVerificationRepository;
        this.certificateVerificationMapper = certificateVerificationMapper;
    }

    @Override
    public CertificateVerificationDto addCertificateVerificationEntity(CertificateVerificationDto certificateVerificationDto) {
        try {
            System.out.println("***In Backend***");
            CertificateVerificationEntity certificateVerificationEntity = certificateVerificationMapper.toCertificateVerificationEntity(certificateVerificationDto);
            CertificateVerificationEntity savedItem =  certificateVerificationRepository.save(certificateVerificationEntity);
            CertificateVerificationDto savedDto = certificateVerificationMapper.toCertificateVerificationDto(savedItem);
            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<CertificateVerificationDto> getData() {

        try {
            List<CertificateVerificationEntity>  certificateVerificationEntityList = certificateVerificationRepository.findAll();
            List<CertificateVerificationDto> certificateVerificationDtoList = certificateVerificationMapper.toCertificateVerificationDtoList(certificateVerificationEntityList);
            return certificateVerificationDtoList;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public CertificateVerificationDto updateCertificateVerification(long id, CertificateVerificationDto certificateVerificationDto) {

        try {
            Optional<CertificateVerificationEntity> optionalCertificateVerificationEntity = certificateVerificationRepository.findById(id);

            if (!optionalCertificateVerificationEntity.isPresent()) {
                throw new AppException("CertificateVerification Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            CertificateVerificationEntity newCertificateVerificationEntity = certificateVerificationMapper.toCertificateVerificationEntity(certificateVerificationDto);

            newCertificateVerificationEntity.setId(id);
            CertificateVerificationEntity savedCertificateVerificationEntity = certificateVerificationRepository.save(newCertificateVerificationEntity);

            CertificateVerificationDto responseCertificateVerificationDto = certificateVerificationMapper.toCertificateVerificationDto(savedCertificateVerificationEntity);
            return responseCertificateVerificationDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public CertificateVerificationDto deleteCertificateVerification(long id) {

        try {
            Optional<CertificateVerificationEntity> optionalCertificateVerificationEntity = certificateVerificationRepository.findById(id);

            if (!optionalCertificateVerificationEntity.isPresent()) {
                throw new AppException("CertificateVerification Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            certificateVerificationRepository.deleteById(id);
            return certificateVerificationMapper.toCertificateVerificationDto(optionalCertificateVerificationEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

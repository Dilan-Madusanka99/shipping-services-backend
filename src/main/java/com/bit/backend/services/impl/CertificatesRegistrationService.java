package com.bit.backend.services.impl;

import com.bit.backend.dtos.CertificatesRegistrationDto;
import com.bit.backend.entities.CertificatesRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.CertificatesRegistrationMapper;
import com.bit.backend.repositories.CertificatesRegistrationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificatesRegistrationService implements CertificatesRegistrationServiceI{

    private final CertificatesRegistrationRepository certificatesRegistrationRepository;
    private final CertificatesRegistrationMapper certificatesRegistrationMapper;

    public CertificatesRegistrationService(CertificatesRegistrationRepository certificatesRegistrationRepository, CertificatesRegistrationMapper certificatesRegistrationMapper) {
        this.certificatesRegistrationRepository = certificatesRegistrationRepository;
        this.certificatesRegistrationMapper = certificatesRegistrationMapper;
    }


    @Override
    public CertificatesRegistrationDto addCertificatesRegistrationEntity(CertificatesRegistrationDto certificatesRegistrationDto) {
        try {
            // System.out.println("***In Backend***");
            CertificatesRegistrationEntity certificatesRegistrationEntity = certificatesRegistrationMapper.toCertificatesRegistrationEntity(certificatesRegistrationDto);
            CertificatesRegistrationEntity savedItem =  certificatesRegistrationRepository.save(certificatesRegistrationEntity);
            CertificatesRegistrationDto savedDto = certificatesRegistrationMapper.toCertificatesRegistrationDto(savedItem);
            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<CertificatesRegistrationDto> getData() {

        try {
            List<CertificatesRegistrationEntity>  certificatesRegistrationEntityList = certificatesRegistrationRepository.findAll();
            List<CertificatesRegistrationDto> certificatesRegistrationDtoList = certificatesRegistrationMapper.toCertificatesRegistrationDtoList(certificatesRegistrationEntityList);
            return certificatesRegistrationDtoList;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public CertificatesRegistrationDto updateCertificatesRegistration(long id, CertificatesRegistrationDto certificatesRegistrationDto) {

        try {
            Optional<CertificatesRegistrationEntity> optionalCertificatesRegistrationEntity = certificatesRegistrationRepository.findById(id);

            if (!optionalCertificatesRegistrationEntity.isPresent()) {
                throw new AppException("Seafarers CertificatesRegistration Registration Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            CertificatesRegistrationEntity newCertificatesRegistrationEntity = certificatesRegistrationMapper.toCertificatesRegistrationEntity(certificatesRegistrationDto);

            newCertificatesRegistrationEntity.setId(id);
            CertificatesRegistrationEntity savedCertificatesRegistrationEntity = certificatesRegistrationRepository.save(newCertificatesRegistrationEntity);

            CertificatesRegistrationDto responseCertificatesRegistrationDto = certificatesRegistrationMapper.toCertificatesRegistrationDto(savedCertificatesRegistrationEntity);
            return responseCertificatesRegistrationDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public CertificatesRegistrationDto deleteCertificatesRegistration(long id) {

        try {
            Optional<CertificatesRegistrationEntity> optionalCertificatesRegistrationEntity = certificatesRegistrationRepository.findById(id);

            if (!optionalCertificatesRegistrationEntity.isPresent()) {
                throw new AppException("Seafarers Other Details Registration Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            certificatesRegistrationRepository.deleteById(id);
            return certificatesRegistrationMapper.toCertificatesRegistrationDto(optionalCertificatesRegistrationEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

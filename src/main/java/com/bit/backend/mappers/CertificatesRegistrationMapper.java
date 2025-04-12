package com.bit.backend.mappers;

import com.bit.backend.dtos.CertificatesRegistrationDto;
import com.bit.backend.entities.CertificatesRegistrationEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper( componentModel = "spring" , builder = @Builder(disableBuilder = true))

public interface CertificatesRegistrationMapper {
    CertificatesRegistrationDto toCertificatesRegistrationDto (CertificatesRegistrationEntity certificatesRegistrationEntity);
    CertificatesRegistrationEntity toCertificatesRegistrationEntity (CertificatesRegistrationDto certificatesRegistrationDto);
    List<CertificatesRegistrationDto> toCertificatesRegistrationDtoList(List<CertificatesRegistrationEntity> certificatesRegistrationEntityList);

}

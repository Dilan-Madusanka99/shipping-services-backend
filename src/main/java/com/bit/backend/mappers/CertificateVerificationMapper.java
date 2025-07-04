package com.bit.backend.mappers;

import com.bit.backend.dtos.CertificateVerificationDto;
import com.bit.backend.entities.CertificateVerificationEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CertificateVerificationMapper {
    CertificateVerificationDto toCertificateVerificationDto (CertificateVerificationEntity certificateVerificationEntity);
    CertificateVerificationEntity toCertificateVerificationEntity (CertificateVerificationDto certificateVerificationDto);
    List<CertificateVerificationDto> toCertificateVerificationDtoList(List<CertificateVerificationEntity> certificateVerificationEntityList);
}

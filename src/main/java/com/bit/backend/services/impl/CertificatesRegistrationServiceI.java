package com.bit.backend.services.impl;

import com.bit.backend.dtos.CertificatesRegistrationDto;
import com.bit.backend.dtos.OtherDetailsRegistrationDto;
import com.bit.backend.entities.SeafarersEntity;

import java.util.List;
import java.util.Optional;

public interface CertificatesRegistrationServiceI {

    CertificatesRegistrationDto addCertificatesRegistrationEntity(CertificatesRegistrationDto certificatesRegistrationDto);
    List<CertificatesRegistrationDto> getData();
    CertificatesRegistrationDto updateCertificatesRegistration(long id, CertificatesRegistrationDto certificatesRegistrationDto);
    CertificatesRegistrationDto deleteCertificatesRegistration(long id);
    CertificatesRegistrationDto getSeafarerData(String sid);
}

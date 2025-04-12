package com.bit.backend.services.impl;

import com.bit.backend.dtos.CertificatesRegistrationDto;

import java.util.List;

public interface CertificatesRegistrationServiceI {

    CertificatesRegistrationDto addCertificatesRegistrationEntity(CertificatesRegistrationDto certificatesRegistrationDto);
    List<CertificatesRegistrationDto> getData();
    CertificatesRegistrationDto updateCertificatesRegistration(long id, CertificatesRegistrationDto certificatesRegistrationDto);
    CertificatesRegistrationDto deleteCertificatesRegistration(long id);
}

package com.bit.backend.services.impl;

import com.bit.backend.dtos.CertificateVerificationDto;

import java.util.List;

public interface CertificateVerificationServiceI {
    CertificateVerificationDto addCertificateVerificationEntity(CertificateVerificationDto certificateVerificationDto);
    List<CertificateVerificationDto> getData();
    CertificateVerificationDto updateCertificateVerification(long id, CertificateVerificationDto certificateVerificationDto);
    CertificateVerificationDto deleteCertificateVerification(long id);
}

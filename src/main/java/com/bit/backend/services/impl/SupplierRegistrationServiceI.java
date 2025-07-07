package com.bit.backend.services.impl;

import com.bit.backend.dtos.SupplierRegistrationDto;

import java.util.List;

public interface SupplierRegistrationServiceI {

    SupplierRegistrationDto addSupplierRegistrationEntity(SupplierRegistrationDto supplierRegistrationDto);
    List<SupplierRegistrationDto> getData();
    SupplierRegistrationDto updateSupplierRegistration(long id, SupplierRegistrationDto supplierRegistrationDto);
    SupplierRegistrationDto deleteSupplierRegistration(long id);
}

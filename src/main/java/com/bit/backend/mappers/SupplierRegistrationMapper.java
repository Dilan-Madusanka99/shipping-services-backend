package com.bit.backend.mappers;

import com.bit.backend.dtos.SupplierRegistrationDto;
import com.bit.backend.entities.SupplierRegistrationEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface SupplierRegistrationMapper {

    SupplierRegistrationDto toSupplierRegistrationDto (SupplierRegistrationEntity supplierRegistrationEntity);
    SupplierRegistrationEntity toSupplierRegistrationEntity (SupplierRegistrationDto supplierRegistrationDto);
    List<SupplierRegistrationDto> toSupplierRegistrationDtoList(List<SupplierRegistrationEntity> supplierRegistrationEntityList);
}

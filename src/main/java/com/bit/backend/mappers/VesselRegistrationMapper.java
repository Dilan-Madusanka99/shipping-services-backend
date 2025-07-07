package com.bit.backend.mappers;

import com.bit.backend.dtos.VesselRegistrationDto;
import com.bit.backend.entities.VesselRegistrationEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface VesselRegistrationMapper {
    VesselRegistrationDto toVesselRegistrationDto (VesselRegistrationEntity vesselRegistrationEntity);
    VesselRegistrationEntity toVesselRegistrationEntity (VesselRegistrationDto vesselRegistrationDto);
    List<VesselRegistrationDto> toVesselRegistrationDtoList(List<VesselRegistrationEntity> vesselRegistrationEntityList);

}

package com.bit.backend.mappers;

import com.bit.backend.dtos.SeaServicesDto;
import com.bit.backend.entities.SeaServicesEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper (componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface SeaServicesMapper {

    SeaServicesDto toSeaServicesDto (SeaServicesEntity seaServicesEntity);
    SeaServicesEntity toSeaServicesEntity (SeaServicesDto eaServicesDto);
    List<SeaServicesDto> toSeaServicesDtoList(List<SeaServicesEntity> seaServicesEntityList);
}

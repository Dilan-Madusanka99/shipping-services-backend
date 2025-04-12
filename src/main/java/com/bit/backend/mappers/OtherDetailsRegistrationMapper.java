package com.bit.backend.mappers;

import com.bit.backend.dtos.OtherDetailsRegistrationDto;
import com.bit.backend.entities.OtherDetailsRegistrationEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper( componentModel = "spring" , builder = @Builder(disableBuilder = true))

public interface OtherDetailsRegistrationMapper {
    OtherDetailsRegistrationDto toOtherDetailsRegistrationDto (OtherDetailsRegistrationEntity otherDetailsRegistrationEntity);
    OtherDetailsRegistrationEntity toOtherDetailsRegistrationEntity (OtherDetailsRegistrationDto otherDetailsRegistrationDto);
    List<OtherDetailsRegistrationDto> toOtherDetailsRegistrationDtoList(List<OtherDetailsRegistrationEntity> otherDetailsRegistrationEntityList);

}

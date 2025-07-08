package com.bit.backend.mappers;

import com.bit.backend.dtos.OnboardCrewRegistrationDto;
import com.bit.backend.entities.OnboardCrewRegistrationEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface OnboardCrewRegistrationMapper {

    OnboardCrewRegistrationDto toOnboardCrewRegistrationDto (OnboardCrewRegistrationEntity onboardCrewRegistrationEntity);
    OnboardCrewRegistrationEntity toOnboardCrewRegistrationEntity (OnboardCrewRegistrationDto eaServicesDto);
    List<OnboardCrewRegistrationDto> toOnboardCrewRegistrationDtoList(List<OnboardCrewRegistrationEntity> onboardCrewRegistrationEntityList);
}

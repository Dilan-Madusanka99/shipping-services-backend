package com.bit.backend.services.impl;

import com.bit.backend.dtos.OnboardCrewRegistrationDto;

import java.util.List;

public interface OnboardCrewRegistrationServiceI {

    OnboardCrewRegistrationDto addOnboardCrewRegistrationEntity(OnboardCrewRegistrationDto onboardCrewRegistrationDto);
    List<OnboardCrewRegistrationDto> getData();
    OnboardCrewRegistrationDto updateOnboardCrewRegistration(long id, OnboardCrewRegistrationDto onboardCrewRegistrationDto);
    OnboardCrewRegistrationDto deleteOnboardCrewRegistration(long id);
}

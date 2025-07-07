package com.bit.backend.services.impl;

import com.bit.backend.dtos.VesselRegistrationDto;

import java.util.List;

public interface VesselRegistrationServiceI {

    VesselRegistrationDto addVesselRegistrationEntity(VesselRegistrationDto vesselRegistrationDto);
    List<VesselRegistrationDto> getData();
    VesselRegistrationDto updateVesselRegistration(long id, VesselRegistrationDto vesselRegistrationDto);
    VesselRegistrationDto deleteVesselRegistration(long id);
}

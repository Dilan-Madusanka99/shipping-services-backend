package com.bit.backend.services.impl;

import com.bit.backend.dtos.SeaServicesDto;

import java.util.List;

public interface SeaServicesServiceI {

    SeaServicesDto addSeaServicesEntity(SeaServicesDto seaServicesDto);
    List<SeaServicesDto> getData();
    SeaServicesDto updateSeaServices(long id, SeaServicesDto seaServicesDto);
    SeaServicesDto deleteSeaServices(long id);
}

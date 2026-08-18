package com.bit.backend.services.impl;

import com.bit.backend.dtos.OtherDetailsRegistrationDto;
import com.bit.backend.dtos.SeafarersDto;

import java.util.List;

public interface OtherDetailsRegistrationServiceI {

    OtherDetailsRegistrationDto addOtherDetailsRegistrationEntity(OtherDetailsRegistrationDto otherDetailsRegistrationDto);
    List<OtherDetailsRegistrationDto> getData();
    OtherDetailsRegistrationDto updateOtherDetailsRegistration(long id, OtherDetailsRegistrationDto otherDetailsRegistrationDto);
    OtherDetailsRegistrationDto deleteOtherDetailsRegistration(long id);
    OtherDetailsRegistrationDto getSeafarerData(String sid);
    OtherDetailsRegistrationDto getSeafarerOtherData(Long sid);
}

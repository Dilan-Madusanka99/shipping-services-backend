package com.bit.backend.services.impl;

import com.bit.backend.dtos.StandbyCrewMembersDto;

import java.util.List;

public interface StandbyCrewMembersServiceI {

    StandbyCrewMembersDto addStandbyCrewMembersEntity(StandbyCrewMembersDto standbyCrewMembersDto);
    List<StandbyCrewMembersDto> getData();
    StandbyCrewMembersDto updateStandbyCrewMembers(long id, StandbyCrewMembersDto standbyCrewMembersDto);
    StandbyCrewMembersDto deleteStandbyCrewMembers(long id);
    List<StandbyCrewMembersDto> getSeafarerData(String sid);
}

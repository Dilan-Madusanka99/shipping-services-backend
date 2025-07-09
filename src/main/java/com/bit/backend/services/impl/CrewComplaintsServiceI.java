package com.bit.backend.services.impl;

import com.bit.backend.dtos.CrewComplaintsDto;

import java.util.List;

public interface CrewComplaintsServiceI {

    CrewComplaintsDto addCrewComplaintsEntity(CrewComplaintsDto crewComplaintsDto);
    List<CrewComplaintsDto> getData();
    CrewComplaintsDto updateCrewComplaints(long id, CrewComplaintsDto crewComplaintsDto);
    CrewComplaintsDto deleteCrewComplaints(long id);
}

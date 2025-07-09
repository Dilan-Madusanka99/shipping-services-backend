package com.bit.backend.mappers;

import com.bit.backend.dtos.CrewComplaintsDto;
import com.bit.backend.entities.CrewComplaintsEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CrewComplaintsMapper {

    CrewComplaintsDto toCrewComplaintsDto (CrewComplaintsEntity crewComplaintsEntity);
    CrewComplaintsEntity toCrewComplaintsEntity (CrewComplaintsDto crewComplaintsDto);
    List<CrewComplaintsDto> toCrewComplaintsDtoList(List<CrewComplaintsEntity> crewComplaintsEntityList);
}

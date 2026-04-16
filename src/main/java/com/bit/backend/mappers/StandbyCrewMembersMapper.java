package com.bit.backend.mappers;

import com.bit.backend.dtos.StandbyCrewMembersDto;
import com.bit.backend.entities.StandbyCrewMembersEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface StandbyCrewMembersMapper {

    StandbyCrewMembersDto toStandbyCrewMembersDto (StandbyCrewMembersEntity standbyCrewMembersEntity);
    StandbyCrewMembersEntity toStandbyCrewMembersEntity (StandbyCrewMembersDto eaServicesDto);
    List<StandbyCrewMembersDto> toStandbyCrewMembersDtoList(List<StandbyCrewMembersEntity> standbyCrewMembersEntityList);
}

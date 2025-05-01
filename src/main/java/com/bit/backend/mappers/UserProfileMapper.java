package com.bit.backend.mappers;

import com.bit.backend.dtos.UserProfileDto;
import com.bit.backend.entities.UserProfileEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper( componentModel = "spring" , builder = @Builder(disableBuilder = true))
public interface UserProfileMapper {

    UserProfileDto toUserProfileDto (UserProfileEntity userProfileEntity);
    UserProfileEntity toUserProfileEntity (UserProfileDto userProfileDto);
    List<UserProfileDto> toUserProfileDtoList(List<UserProfileEntity> userProfileEntityList);
}

package com.bit.backend.mappers;

import com.bit.backend.dtos.LoginDto;
import com.bit.backend.entities.LoginEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface LoginMapper {
    LoginDto toLoginDto (LoginEntity loginEntity);
    LoginEntity toLoginEntity (LoginDto loginDto);
    List<LoginDto> toLoginDtoList(List<LoginEntity> loginEntityList);
}

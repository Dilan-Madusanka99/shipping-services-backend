package com.bit.backend.mappers;

import com.bit.backend.dtos.SeafarersDto;
import com.bit.backend.entities.SeafarersEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper( componentModel = "spring" , builder = @Builder (disableBuilder = true))
public interface SeafarersMapper {

    SeafarersDto toSeafarersDto (SeafarersEntity seafarersEntity);
    SeafarersEntity toSeafarersEntity (SeafarersDto seafarersDto);
    List<SeafarersDto> toSeafarersDtoList(List<SeafarersEntity> seafarersEntityList);

}

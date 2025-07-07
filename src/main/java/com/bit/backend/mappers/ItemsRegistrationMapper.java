package com.bit.backend.mappers;

import com.bit.backend.dtos.ItemsRegistrationDto;
import com.bit.backend.entities.ItemsRegistrationEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface ItemsRegistrationMapper {

    ItemsRegistrationDto toItemsRegistrationDto (ItemsRegistrationEntity itemsRegistrationEntity);
    ItemsRegistrationEntity toItemsRegistrationEntity (ItemsRegistrationDto itemsRegistrationDto);
    List<ItemsRegistrationDto> toItemsRegistrationDtoList(List<ItemsRegistrationEntity> itemsRegistrationEntityList);
    
}

package com.bit.backend.services.impl;

import com.bit.backend.dtos.ItemsRegistrationDto;

import java.util.List;

public interface ItemsRegistrationServiceI {

    ItemsRegistrationDto addItemsRegistrationEntity(ItemsRegistrationDto itemsRegistrationDto);
    List<ItemsRegistrationDto> getData();
    ItemsRegistrationDto updateItemsRegistration(long id, ItemsRegistrationDto itemsRegistrationDto);
    ItemsRegistrationDto deleteItemsRegistration(long id);
}

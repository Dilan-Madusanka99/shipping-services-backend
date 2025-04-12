package com.bit.backend.services.impl;

import com.bit.backend.dtos.SeafarersDto;

import java.util.List;

public interface SeafarersServiceI {

    SeafarersDto addSeafarersEntity(SeafarersDto seafarersDto);
    List<SeafarersDto> getData();
    SeafarersDto updateSeafarers(long id, SeafarersDto seafarersDto);
    SeafarersDto deleteSeafarers(long id);
}

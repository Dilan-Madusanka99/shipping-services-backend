package com.bit.backend.services.impl;

import com.bit.backend.dtos.SeafarersDto;

import java.util.List;

public interface SeafarersServiceI {

    SeafarersDto addSeafarersEntity(SeafarersDto seafarersDto);
    List<SeafarersDto> getData();
    List<SeafarersDto> seafarersRegisteredByMonth();
    SeafarersDto updateSeafarers(long id, SeafarersDto seafarersDto);
    SeafarersDto deleteSeafarers(long id);
}

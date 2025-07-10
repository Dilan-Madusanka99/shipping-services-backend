package com.bit.backend.services.impl;

import com.bit.backend.dtos.StocksDto;

import java.util.List;

public interface StocksServiceI {

    StocksDto addStocksEntity(StocksDto stocksDto);
    List<StocksDto> getData();
    StocksDto updateStocks(long id, StocksDto stocksDto);
    StocksDto deleteStocks(long id);
}

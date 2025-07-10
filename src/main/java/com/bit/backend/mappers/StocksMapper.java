package com.bit.backend.mappers;

import com.bit.backend.dtos.StocksDto;
import com.bit.backend.entities.StocksEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface StocksMapper {

    StocksDto toStocksDto (StocksEntity stocksEntity);
    StocksEntity toStocksEntity (StocksDto stocksDto);
    List<StocksDto> toStocksDtoList(List<StocksEntity> stocksEntityList);
}

package com.bit.backend.services.impl;

import com.bit.backend.dtos.StocksDto;
import com.bit.backend.entities.SeafarersEntity;
import com.bit.backend.entities.StocksEntity;
import com.bit.backend.entities.SupplierRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.StocksMapper;
import com.bit.backend.repositories.StocksRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StocksService implements StocksServiceI{

    private final StocksRepository stocksRepository;
    private final StocksMapper stocksMapper;

    public StocksService(StocksRepository stocksRepository, StocksMapper stocksMapper) {
        this.stocksRepository = stocksRepository;
        this.stocksMapper = stocksMapper;
    }

    @Override
    public StocksDto addStocksEntity(StocksDto stocksDto) {
        try {

            if (stocksDto.getQuantity() == null || stocksDto.getQuantity().isEmpty()) {
                throw new AppException("Quantity Is Empty", HttpStatus.BAD_REQUEST);
            }

            System.out.println("***In Backend***");
            StocksEntity stocksEntity = stocksMapper.toStocksEntity(stocksDto);
            StocksEntity savedItem =  stocksRepository.save(stocksEntity);
            StocksDto savedDto = stocksMapper.toStocksDto(savedItem);
            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<StocksDto> getData() {

        try {
            List<StocksEntity>  stocksEntityList = stocksRepository.findAll();
            List<StocksDto> stocksDtoList = stocksMapper.toStocksDtoList(stocksEntityList);
            return stocksDtoList;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public StocksDto updateStocks(long id, StocksDto stocksDto) {

        try {
            Optional<StocksEntity> optionalStocksEntity = stocksRepository.findById(id);

            if (!optionalStocksEntity.isPresent()) {
                throw new AppException("Stocks Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            StocksEntity newStocksEntity = stocksMapper.toStocksEntity(stocksDto);

            newStocksEntity.setId(id);
            StocksEntity savedStocksEntity = stocksRepository.save(newStocksEntity);

            StocksDto responseStocksDto = stocksMapper.toStocksDto(savedStocksEntity);
            return responseStocksDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public StocksDto deleteStocks(long id) {

        try {
            Optional<StocksEntity> optionalStocksEntity = stocksRepository.findById(id);

            if (!optionalStocksEntity.isPresent()) {
                throw new AppException("Stocks Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            stocksRepository.deleteById(id);
            return stocksMapper.toStocksDto(optionalStocksEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

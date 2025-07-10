package com.bit.backend.controllers;

import com.bit.backend.dtos.StocksDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.impl.StocksServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class StocksController {

    private final StocksServiceI stocksServiceI;

    public StocksController(StocksServiceI stocksServiceI) {this.stocksServiceI = stocksServiceI;}

    @PostMapping("/stocks")
    public ResponseEntity<StocksDto> addStocks(@RequestBody StocksDto stocksDto) {

        try {
            StocksDto stocksDtoResponse = stocksServiceI.addStocksEntity(stocksDto);
            return ResponseEntity.created(URI.create("/stocks"+stocksDtoResponse.getItemNo())).body(stocksDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/stocks")
    public ResponseEntity<List<StocksDto>> getData() {

        try {
            List<StocksDto> stocksDtoList = stocksServiceI.getData();
            return ResponseEntity.ok(stocksDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/stocks/{id}")
    public ResponseEntity<StocksDto> updateStocks(@PathVariable Long id, @RequestBody StocksDto stocksDto) {

        try {
            StocksDto responseStocksDto = stocksServiceI.updateStocks(id, stocksDto);
            return ResponseEntity.ok(responseStocksDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/stocks/{id}")
    public ResponseEntity<StocksDto> deleteStocks(@PathVariable Long id) {

        try {
            StocksDto stocksDto = stocksServiceI.deleteStocks(id);
            return ResponseEntity.ok(stocksDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

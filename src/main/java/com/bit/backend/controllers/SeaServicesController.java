package com.bit.backend.controllers;

import com.bit.backend.dtos.SeaServicesDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.impl.SeaServicesServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class SeaServicesController {

    private final SeaServicesServiceI seaServicesServiceI;

    public SeaServicesController(SeaServicesServiceI seaServicesServiceI) {this.seaServicesServiceI = seaServicesServiceI;}

    @PostMapping("/seaServices")
    public ResponseEntity<SeaServicesDto> addSeaServices(@RequestBody SeaServicesDto seaServicesDto) {

        try {
            SeaServicesDto seaServicesDtoResponse = seaServicesServiceI.addSeaServicesEntity(seaServicesDto);
            return ResponseEntity.created(URI.create("/seaServices"+seaServicesDtoResponse.getSidNo())).body(seaServicesDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/seaServices")
    public ResponseEntity<List<SeaServicesDto>> getData() {

        try {
            List<SeaServicesDto> seaServicesDtoList = seaServicesServiceI.getData();
            return ResponseEntity.ok(seaServicesDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/seaServices/{id}")
    public ResponseEntity<SeaServicesDto> updateSeaServices(@PathVariable Long id, @RequestBody SeaServicesDto seaServicesDto) {

        try {
            SeaServicesDto responseSeaServicesDto = seaServicesServiceI.updateSeaServices(id, seaServicesDto);
            return ResponseEntity.ok(responseSeaServicesDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/seaServices/{id}")
    public ResponseEntity<SeaServicesDto> deleteSeaServices(@PathVariable Long id) {

        try {
            SeaServicesDto seaServicesDto = seaServicesServiceI.deleteSeaServices(id);
            return ResponseEntity.ok(seaServicesDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

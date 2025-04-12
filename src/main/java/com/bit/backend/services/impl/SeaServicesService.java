package com.bit.backend.services.impl;

import com.bit.backend.dtos.SeaServicesDto;
import com.bit.backend.entities.SeaServicesEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.SeaServicesMapper;
import com.bit.backend.repositories.SeaServicesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeaServicesService implements SeaServicesServiceI {

    private final SeaServicesRepository seaServicesRepository;
    private final SeaServicesMapper seaServicesMapper;


    public SeaServicesService(SeaServicesRepository seaServicesRepository, SeaServicesMapper seaServicesMapper) {
        this.seaServicesRepository = seaServicesRepository;
        this.seaServicesMapper = seaServicesMapper;
    }

    @Override
    public SeaServicesDto addSeaServicesEntity(SeaServicesDto seaServicesDto) {
        try {
            System.out.println("***In Backend***");
            SeaServicesEntity seaServicesEntity = seaServicesMapper.toSeaServicesEntity(seaServicesDto);
            SeaServicesEntity savedItem =  seaServicesRepository.save(seaServicesEntity);
            SeaServicesDto savedDto = seaServicesMapper.toSeaServicesDto(savedItem);
            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<SeaServicesDto> getData() {

        try {
            List<SeaServicesEntity> seaServicesEntityList = seaServicesRepository.findAll();
            List<SeaServicesDto> seaServicesDtoList = seaServicesMapper.toSeaServicesDtoList(seaServicesEntityList);
            return seaServicesDtoList;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public SeaServicesDto updateSeaServices(long id, SeaServicesDto seaServicesDto) {

        try {
            Optional<SeaServicesEntity> optionalSeaServicesEntity = seaServicesRepository.findById(id);

            if (!optionalSeaServicesEntity.isPresent()) {
                throw new AppException("SeaServices Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            SeaServicesEntity newSeaServicesEntity = seaServicesMapper.toSeaServicesEntity(seaServicesDto);

            newSeaServicesEntity.setId(id);
            SeaServicesEntity savedSeaServicesEntity = seaServicesRepository.save(newSeaServicesEntity);

            SeaServicesDto responseSeaServicesDto = seaServicesMapper.toSeaServicesDto(savedSeaServicesEntity);
            return responseSeaServicesDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public SeaServicesDto deleteSeaServices(long id) {

        try {
            Optional<SeaServicesEntity> optionalSeaServicesEntity = seaServicesRepository.findById(id);

            if (!optionalSeaServicesEntity.isPresent()) {
                throw new AppException("SeaServices Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            seaServicesRepository.deleteById(id);
            return seaServicesMapper.toSeaServicesDto(optionalSeaServicesEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

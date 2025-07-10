package com.bit.backend.services.impl;

import com.bit.backend.dtos.VesselRegistrationDto;
import com.bit.backend.entities.SeafarersEntity;
import com.bit.backend.entities.VesselRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.VesselRegistrationMapper;
import com.bit.backend.repositories.VesselRegistrationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VesselRegistrationService implements VesselRegistrationServiceI{

    private final VesselRegistrationRepository vesselRegistrationRepository;
    private final VesselRegistrationMapper vesselRegistrationMapper;

    public VesselRegistrationService(VesselRegistrationRepository vesselRegistrationRepository, VesselRegistrationMapper vesselRegistrationMapper) {
        this.vesselRegistrationRepository = vesselRegistrationRepository;
        this.vesselRegistrationMapper = vesselRegistrationMapper;
    }

    @Override
    public VesselRegistrationDto addVesselRegistrationEntity(VesselRegistrationDto vesselRegistrationDto) {
        try {
            System.out.println("***In Backend***");

            Optional<VesselRegistrationEntity> optionalVesselRegistrationEntity = vesselRegistrationRepository.findByImoNo(vesselRegistrationDto.getImoNo());

            if (optionalVesselRegistrationEntity.isPresent()) {
                throw new AppException("Vessel Already Exists", HttpStatus.BAD_REQUEST);
            }

            VesselRegistrationEntity vesselRegistrationEntity = vesselRegistrationMapper.toVesselRegistrationEntity(vesselRegistrationDto);
            VesselRegistrationEntity savedItem =  vesselRegistrationRepository.save(vesselRegistrationEntity);
            VesselRegistrationDto savedDto = vesselRegistrationMapper.toVesselRegistrationDto(savedItem);
            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<VesselRegistrationDto> getData() {

        try {
            List<VesselRegistrationEntity>  vesselRegistrationEntityList = vesselRegistrationRepository.findAll();
            List<VesselRegistrationDto> vesselRegistrationDtoList = vesselRegistrationMapper.toVesselRegistrationDtoList(vesselRegistrationEntityList);
            return vesselRegistrationDtoList;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public VesselRegistrationDto updateVesselRegistration(long id, VesselRegistrationDto vesselRegistrationDto) {

        try {
            Optional<VesselRegistrationEntity> optionalVesselRegistrationEntity = vesselRegistrationRepository.findById(id);

            if (!optionalVesselRegistrationEntity.isPresent()) {
                throw new AppException("Vessel Registration Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            VesselRegistrationEntity newVesselRegistrationEntity = vesselRegistrationMapper.toVesselRegistrationEntity(vesselRegistrationDto);

            newVesselRegistrationEntity.setId(id);
            VesselRegistrationEntity savedVesselRegistrationEntity = vesselRegistrationRepository.save(newVesselRegistrationEntity);

            VesselRegistrationDto responseVesselRegistrationDto = vesselRegistrationMapper.toVesselRegistrationDto(savedVesselRegistrationEntity);
            return responseVesselRegistrationDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public VesselRegistrationDto deleteVesselRegistration(long id) {

        try {
            Optional<VesselRegistrationEntity> optionalVesselRegistrationEntity = vesselRegistrationRepository.findById(id);

            if (!optionalVesselRegistrationEntity.isPresent()) {
                throw new AppException("Vessel Registration Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            vesselRegistrationRepository.deleteById(id);
            return vesselRegistrationMapper.toVesselRegistrationDto(optionalVesselRegistrationEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

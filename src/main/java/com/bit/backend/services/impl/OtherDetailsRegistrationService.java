package com.bit.backend.services.impl;

import com.bit.backend.dtos.OtherDetailsRegistrationDto;
import com.bit.backend.entities.OtherDetailsRegistrationEntity;
import com.bit.backend.entities.SeafarersEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.OtherDetailsRegistrationMapper;
import com.bit.backend.repositories.OtherDetailsRegistrationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OtherDetailsRegistrationService implements OtherDetailsRegistrationServiceI {

    private final OtherDetailsRegistrationRepository otherDetailsRegistrationRepository;
    private final OtherDetailsRegistrationMapper otherDetailsRegistrationMapper;

    public OtherDetailsRegistrationService(OtherDetailsRegistrationRepository otherDetailsRegistrationRepository, OtherDetailsRegistrationMapper otherDetailsRegistrationMapper) {
        this.otherDetailsRegistrationRepository = otherDetailsRegistrationRepository;
        this.otherDetailsRegistrationMapper = otherDetailsRegistrationMapper;
    }


    @Override
    public OtherDetailsRegistrationDto addOtherDetailsRegistrationEntity(OtherDetailsRegistrationDto otherDetailsRegistrationDto) {
        try {
            System.out.println("***In Backend***");

            Optional<OtherDetailsRegistrationEntity> optionalOtherDetailsRegistrationEntity = otherDetailsRegistrationRepository.findByPpNo(otherDetailsRegistrationDto.getPpNo());

            if (optionalOtherDetailsRegistrationEntity.isPresent()) {
                throw new AppException("Seafarer Already Exists", HttpStatus.BAD_REQUEST);
            }

            OtherDetailsRegistrationEntity otherDetailsRegistrationEntity = otherDetailsRegistrationMapper.toOtherDetailsRegistrationEntity(otherDetailsRegistrationDto);
            OtherDetailsRegistrationEntity savedItem =  otherDetailsRegistrationRepository.save(otherDetailsRegistrationEntity);
            OtherDetailsRegistrationDto savedDto = otherDetailsRegistrationMapper.toOtherDetailsRegistrationDto(savedItem);
            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<OtherDetailsRegistrationDto> getData() {

        try {
            List<OtherDetailsRegistrationEntity>  otherDetailsRegistrationEntityList = otherDetailsRegistrationRepository.findAll();
            List<OtherDetailsRegistrationDto> otherDetailsRegistrationDtoList = otherDetailsRegistrationMapper.toOtherDetailsRegistrationDtoList(otherDetailsRegistrationEntityList);
            return otherDetailsRegistrationDtoList;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public OtherDetailsRegistrationDto updateOtherDetailsRegistration(long id, OtherDetailsRegistrationDto otherDetailsRegistrationDto) {

        try {
            Optional<OtherDetailsRegistrationEntity> optionalOtherDetailsRegistrationEntity = otherDetailsRegistrationRepository.findById(id);

            if (!optionalOtherDetailsRegistrationEntity.isPresent()) {
                throw new AppException("Seafarers OtherDetailsRegistration Registration Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            OtherDetailsRegistrationEntity newOtherDetailsRegistrationEntity = otherDetailsRegistrationMapper.toOtherDetailsRegistrationEntity(otherDetailsRegistrationDto);

            newOtherDetailsRegistrationEntity.setId(id);
            OtherDetailsRegistrationEntity savedOtherDetailsRegistrationEntity = otherDetailsRegistrationRepository.save(newOtherDetailsRegistrationEntity);

            OtherDetailsRegistrationDto responseOtherDetailsRegistrationDto = otherDetailsRegistrationMapper.toOtherDetailsRegistrationDto(savedOtherDetailsRegistrationEntity);
            return responseOtherDetailsRegistrationDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public OtherDetailsRegistrationDto deleteOtherDetailsRegistration(long id) {

        try {
            Optional<OtherDetailsRegistrationEntity> optionalOtherDetailsRegistrationEntity = otherDetailsRegistrationRepository.findById(id);

            if (!optionalOtherDetailsRegistrationEntity.isPresent()) {
                throw new AppException("Seafarers Other Details Registration Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            otherDetailsRegistrationRepository.deleteById(id);
            return otherDetailsRegistrationMapper.toOtherDetailsRegistrationDto(optionalOtherDetailsRegistrationEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

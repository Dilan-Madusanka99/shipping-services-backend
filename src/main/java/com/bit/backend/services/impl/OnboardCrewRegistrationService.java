package com.bit.backend.services.impl;

import com.bit.backend.dtos.OnboardCrewRegistrationDto;
import com.bit.backend.entities.OnboardCrewRegistrationEntity;
import com.bit.backend.entities.SeafarersEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.OnboardCrewRegistrationMapper;
import com.bit.backend.repositories.OnboardCrewRegistrationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OnboardCrewRegistrationService implements OnboardCrewRegistrationServiceI{

    private final OnboardCrewRegistrationRepository onboardCrewRegistrationRepository;
    private final OnboardCrewRegistrationMapper onboardCrewRegistrationMapper;

    public OnboardCrewRegistrationService(OnboardCrewRegistrationRepository onboardCrewRegistrationRepository, OnboardCrewRegistrationMapper onboardCrewRegistrationMapper) {
        this.onboardCrewRegistrationRepository = onboardCrewRegistrationRepository;
        this.onboardCrewRegistrationMapper = onboardCrewRegistrationMapper;
    }

    @Override
    public OnboardCrewRegistrationDto addOnboardCrewRegistrationEntity(OnboardCrewRegistrationDto onboardCrewRegistrationDto) {
        try {
            System.out.println("***In Backend***");

            Optional<OnboardCrewRegistrationEntity> optionalOnboardCrewRegistrationEntity = onboardCrewRegistrationRepository.findBySidNo(onboardCrewRegistrationDto.getSidNo());

            if (optionalOnboardCrewRegistrationEntity.isPresent()) {
                throw new AppException("Seafarer Already Exists", HttpStatus.BAD_REQUEST);
            }

            OnboardCrewRegistrationEntity onboardCrewRegistrationEntity = onboardCrewRegistrationMapper.toOnboardCrewRegistrationEntity(onboardCrewRegistrationDto);
            OnboardCrewRegistrationEntity savedItem =  onboardCrewRegistrationRepository.save(onboardCrewRegistrationEntity);
            OnboardCrewRegistrationDto savedDto = onboardCrewRegistrationMapper.toOnboardCrewRegistrationDto(savedItem);
            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<OnboardCrewRegistrationDto> getData() {

        try {
            List<OnboardCrewRegistrationEntity> onboardCrewRegistrationEntityList = onboardCrewRegistrationRepository.findAll();
            List<OnboardCrewRegistrationDto> onboardCrewRegistrationDtoList = onboardCrewRegistrationMapper.toOnboardCrewRegistrationDtoList(onboardCrewRegistrationEntityList);
            return onboardCrewRegistrationDtoList;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public OnboardCrewRegistrationDto updateOnboardCrewRegistration(long id, OnboardCrewRegistrationDto onboardCrewRegistrationDto) {

        try {
            Optional<OnboardCrewRegistrationEntity> optionalOnboardCrewRegistrationEntity = onboardCrewRegistrationRepository.findById(id);

            if (!optionalOnboardCrewRegistrationEntity.isPresent()) {
                throw new AppException("OnboardCrewRegistration Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            OnboardCrewRegistrationEntity newOnboardCrewRegistrationEntity = onboardCrewRegistrationMapper.toOnboardCrewRegistrationEntity(onboardCrewRegistrationDto);

            newOnboardCrewRegistrationEntity.setId(id);
            OnboardCrewRegistrationEntity savedOnboardCrewRegistrationEntity = onboardCrewRegistrationRepository.save(newOnboardCrewRegistrationEntity);

            OnboardCrewRegistrationDto responseOnboardCrewRegistrationDto = onboardCrewRegistrationMapper.toOnboardCrewRegistrationDto(savedOnboardCrewRegistrationEntity);
            return responseOnboardCrewRegistrationDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public OnboardCrewRegistrationDto deleteOnboardCrewRegistration(long id) {

        try {
            Optional<OnboardCrewRegistrationEntity> optionalOnboardCrewRegistrationEntity = onboardCrewRegistrationRepository.findById(id);

            if (!optionalOnboardCrewRegistrationEntity.isPresent()) {
                throw new AppException("OnboardCrewRegistration Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            onboardCrewRegistrationRepository.deleteById(id);
            return onboardCrewRegistrationMapper.toOnboardCrewRegistrationDto(optionalOnboardCrewRegistrationEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

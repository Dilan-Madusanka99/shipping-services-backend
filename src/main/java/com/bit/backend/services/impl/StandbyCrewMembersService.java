package com.bit.backend.services.impl;

import com.bit.backend.dtos.StandbyCrewMembersDto;
import com.bit.backend.entities.StandbyCrewMembersEntity;
import com.bit.backend.entities.SeafarersEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.StandbyCrewMembersMapper;
import com.bit.backend.repositories.SeafarersRepository;
import com.bit.backend.repositories.StandbyCrewMembersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StandbyCrewMembersService implements StandbyCrewMembersServiceI{

    private final StandbyCrewMembersRepository standbyCrewMembersRepository;
    private final StandbyCrewMembersMapper standbyCrewMembersMapper;
    private final SeafarersRepository seafarersRepository;

    public StandbyCrewMembersService(StandbyCrewMembersRepository standbyCrewMembersRepository, StandbyCrewMembersMapper standbyCrewMembersMapper, SeafarersRepository seafarersRepository) {
        this.standbyCrewMembersRepository = standbyCrewMembersRepository;
        this.standbyCrewMembersMapper = standbyCrewMembersMapper;
        this.seafarersRepository = seafarersRepository;
    }

    @Override
    public StandbyCrewMembersDto addStandbyCrewMembersEntity(StandbyCrewMembersDto standbyCrewMembersDto) {
        try {
            System.out.println("***In Backend***");

            Optional<List<StandbyCrewMembersEntity>> optionalStandbyCrewMembersEntity = standbyCrewMembersRepository.findBySidNo(standbyCrewMembersDto.getSidNo());

            if (optionalStandbyCrewMembersEntity.isPresent()) {
                throw new AppException("Seafarer Already Exists", HttpStatus.BAD_REQUEST);
            }

            if (standbyCrewMembersDto.getSidNo() == null || standbyCrewMembersDto.getSidNo().isEmpty()) {
                throw new AppException("SID No is Empty", HttpStatus.BAD_REQUEST);
            }

            StandbyCrewMembersEntity standbyCrewMembersEntity = standbyCrewMembersMapper.toStandbyCrewMembersEntity(standbyCrewMembersDto);
            StandbyCrewMembersEntity savedItem =  standbyCrewMembersRepository.save(standbyCrewMembersEntity);
            StandbyCrewMembersDto savedDto = standbyCrewMembersMapper.toStandbyCrewMembersDto(savedItem);
            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<StandbyCrewMembersDto> getData() {

        try {
            List<StandbyCrewMembersEntity> standbyCrewMembersEntityList = standbyCrewMembersRepository.findAll();
            List<StandbyCrewMembersDto> standbyCrewMembersDtoList = standbyCrewMembersMapper.toStandbyCrewMembersDtoList(standbyCrewMembersEntityList);
            return standbyCrewMembersDtoList;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public StandbyCrewMembersDto updateStandbyCrewMembers(long id, StandbyCrewMembersDto standbyCrewMembersDto) {

        try {
            Optional<StandbyCrewMembersEntity> optionalStandbyCrewMembersEntity = standbyCrewMembersRepository.findById(id);

            if (!optionalStandbyCrewMembersEntity.isPresent()) {
                throw new AppException("StandbyCrewMembers Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            StandbyCrewMembersEntity newStandbyCrewMembersEntity = standbyCrewMembersMapper.toStandbyCrewMembersEntity(standbyCrewMembersDto);

            newStandbyCrewMembersEntity.setId(id);
            StandbyCrewMembersEntity savedStandbyCrewMembersEntity = standbyCrewMembersRepository.save(newStandbyCrewMembersEntity);

            StandbyCrewMembersDto responseStandbyCrewMembersDto = standbyCrewMembersMapper.toStandbyCrewMembersDto(savedStandbyCrewMembersEntity);
            return responseStandbyCrewMembersDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public StandbyCrewMembersDto deleteStandbyCrewMembers(long id) {

        try {
            Optional<StandbyCrewMembersEntity> optionalStandbyCrewMembersEntity = standbyCrewMembersRepository.findById(id);

            if (!optionalStandbyCrewMembersEntity.isPresent()) {
                throw new AppException("StandbyCrewMembers Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            standbyCrewMembersRepository.deleteById(id);
            return standbyCrewMembersMapper.toStandbyCrewMembersDto(optionalStandbyCrewMembersEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<StandbyCrewMembersDto> getSeafarerData(String sid) {
        try {

            Optional<SeafarersEntity> optionalSeafarersEntity = seafarersRepository.findBySidNo(sid);

            if (!optionalSeafarersEntity.isPresent()) {
                throw new AppException("Seafarer Registration Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            SeafarersEntity seafarersEntity = optionalSeafarersEntity.get();

            Optional<List<StandbyCrewMembersEntity>> optionalStandbyCrewMembersEntity = standbyCrewMembersRepository.findBySidNo(seafarersEntity.getId().toString());

            if (!optionalStandbyCrewMembersEntity.isPresent()) {
                throw new AppException("Onboard Crew Registration Does Not Exists", HttpStatus.BAD_REQUEST);
            }
            return standbyCrewMembersMapper.toStandbyCrewMembersDtoList(optionalStandbyCrewMembersEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

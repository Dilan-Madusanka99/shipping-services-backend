package com.bit.backend.services.impl;

import com.bit.backend.dtos.CrewComplaintsDto;
import com.bit.backend.entities.CrewComplaintsEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.CrewComplaintsMapper;
import com.bit.backend.repositories.CrewComplaintsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrewComplaintsService implements CrewComplaintsServiceI{

    private final CrewComplaintsRepository crewComplaintsRepository;
    private final CrewComplaintsMapper crewComplaintsMapper;

    public CrewComplaintsService(CrewComplaintsRepository crewComplaintsRepository, CrewComplaintsMapper crewComplaintsMapper) {
        this.crewComplaintsRepository = crewComplaintsRepository;
        this.crewComplaintsMapper = crewComplaintsMapper;
    }

    @Override
    public CrewComplaintsDto addCrewComplaintsEntity(CrewComplaintsDto crewComplaintsDto) {
        try {
            System.out.println("***In Backend***");
            CrewComplaintsEntity crewComplaintsEntity = crewComplaintsMapper.toCrewComplaintsEntity(crewComplaintsDto);
            CrewComplaintsEntity savedItem =  crewComplaintsRepository.save(crewComplaintsEntity);
            CrewComplaintsDto savedDto = crewComplaintsMapper.toCrewComplaintsDto(savedItem);
            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<CrewComplaintsDto> getData() {

        try {
            List<CrewComplaintsEntity> crewComplaintsEntityList = crewComplaintsRepository.findAll();
            List<CrewComplaintsDto> crewComplaintsDtoList = crewComplaintsMapper.toCrewComplaintsDtoList(crewComplaintsEntityList);
            return crewComplaintsDtoList;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public CrewComplaintsDto updateCrewComplaints(long id, CrewComplaintsDto crewComplaintsDto) {

        try {
            Optional<CrewComplaintsEntity> optionalCrewComplaintsEntity = crewComplaintsRepository.findById(id);

            if (!optionalCrewComplaintsEntity.isPresent()) {
                throw new AppException("Crew Complaints Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            CrewComplaintsEntity newCrewComplaintsEntity = crewComplaintsMapper.toCrewComplaintsEntity(crewComplaintsDto);

            newCrewComplaintsEntity.setId(id);
            CrewComplaintsEntity savedCrewComplaintsEntity = crewComplaintsRepository.save(newCrewComplaintsEntity);

            CrewComplaintsDto responseCrewComplaintsDto = crewComplaintsMapper.toCrewComplaintsDto(savedCrewComplaintsEntity);
            return responseCrewComplaintsDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public CrewComplaintsDto deleteCrewComplaints(long id) {

        try {
            Optional<CrewComplaintsEntity> optionalCrewComplaintsEntity = crewComplaintsRepository.findById(id);

            if (!optionalCrewComplaintsEntity.isPresent()) {
                throw new AppException("Crew Complaints Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            crewComplaintsRepository.deleteById(id);
            return crewComplaintsMapper.toCrewComplaintsDto(optionalCrewComplaintsEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.bit.backend.services.impl;

import com.bit.backend.dtos.EmployeeAttendenceDto;
import com.bit.backend.entities.EmployeeAttendenceEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.EmployeeAttendenceMapper;
import com.bit.backend.repositories.EmployeeAttendenceRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeAttendenceService implements EmployeeAttendenceServiceI {

    private final EmployeeAttendenceRepository employeeAttendenceRepository;
    private final EmployeeAttendenceMapper employeeAttendenceMapper;

    public EmployeeAttendenceService(EmployeeAttendenceRepository employeeAttendenceRepository, EmployeeAttendenceMapper employeeAttendenceMapper) {
        this.employeeAttendenceRepository = employeeAttendenceRepository;
        this.employeeAttendenceMapper = employeeAttendenceMapper;
    }

    @Override
    public EmployeeAttendenceDto addEmployeeAttendenceEntity(EmployeeAttendenceDto employeeAttendenceDto) {
        try {
            System.out.println("***In Backend***");
            EmployeeAttendenceEntity employeeAttendenceEntity = employeeAttendenceMapper.toEmployeeAttendenceEntity(employeeAttendenceDto);
            EmployeeAttendenceEntity savedItem =  employeeAttendenceRepository.save(employeeAttendenceEntity);
            EmployeeAttendenceDto savedDto = employeeAttendenceMapper.toEmployeeAttendenceDto(savedItem);
            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<EmployeeAttendenceDto> getData() {

        try {
            List<EmployeeAttendenceEntity>  employeeAttendenceEntityList = employeeAttendenceRepository.findAll();
            List<EmployeeAttendenceDto> employeeAttendenceDtoList = employeeAttendenceMapper.toEmployeeAttendenceDtoList(employeeAttendenceEntityList);
            return employeeAttendenceDtoList;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public EmployeeAttendenceDto updateEmployeeAttendence(long id, EmployeeAttendenceDto employeeAttendenceDto) {

        try {
            Optional<EmployeeAttendenceEntity> optionalEmployeeAttendenceEntity = employeeAttendenceRepository.findById(id);

            if (!optionalEmployeeAttendenceEntity.isPresent()) {
                throw new AppException("EmployeeAttendence Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            EmployeeAttendenceEntity newEmployeeAttendenceEntity = employeeAttendenceMapper.toEmployeeAttendenceEntity(employeeAttendenceDto);

            newEmployeeAttendenceEntity.setId(id);
            EmployeeAttendenceEntity savedEmployeeAttendenceEntity = employeeAttendenceRepository.save(newEmployeeAttendenceEntity);

            EmployeeAttendenceDto responseEmployeeAttendenceDto = employeeAttendenceMapper.toEmployeeAttendenceDto(savedEmployeeAttendenceEntity);
            return responseEmployeeAttendenceDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @Override
    public EmployeeAttendenceDto deleteEmployeeAttendence(long id) {

        try {
            Optional<EmployeeAttendenceEntity> optionalEmployeeAttendenceEntity = employeeAttendenceRepository.findById(id);

            if (!optionalEmployeeAttendenceEntity.isPresent()) {
                throw new AppException("EmployeeAttendence Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            employeeAttendenceRepository.deleteById(id);
            return employeeAttendenceMapper.toEmployeeAttendenceDto(optionalEmployeeAttendenceEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

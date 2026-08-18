package com.bit.backend.services.impl;

import com.bit.backend.dtos.EmployeeAttendenceDto;
import com.bit.backend.entities.EmployeeAttendenceEntity;
import com.bit.backend.entities.EmployeeEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.EmployeeAttendenceMapper;
import com.bit.backend.repositories.EmployeeAttendenceRepository;
import com.bit.backend.repositories.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeAttendenceService implements EmployeeAttendenceServiceI {

    private final EmployeeAttendenceRepository employeeAttendenceRepository;
    private final EmployeeAttendenceMapper employeeAttendenceMapper;
    private final EmployeeRepository employeeRepository;

    public EmployeeAttendenceService(EmployeeAttendenceRepository employeeAttendenceRepository, EmployeeAttendenceMapper employeeAttendenceMapper, EmployeeRepository employeeRepository) {
        this.employeeAttendenceRepository = employeeAttendenceRepository;
        this.employeeAttendenceMapper = employeeAttendenceMapper;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeAttendenceDto addEmployeeAttendenceEntity(EmployeeAttendenceDto employeeAttendenceDto) {
        try {
            System.out.println("***In Backend***");

            // validation to check if the same Employee has the attenadance marked for same date
            EmployeeAttendenceEntity employeeAttendenceEntityValidation = employeeAttendenceRepository.findByUsersAndAttandenceDate(employeeAttendenceDto.getUsers(), LocalDate.now());

            if (employeeAttendenceEntityValidation != null) {
                throw new AppException("Attendance already marked for the employee for today", HttpStatus.BAD_REQUEST);
            }

            if (employeeAttendenceDto.getUsers() == null || employeeAttendenceDto.getUsers().isEmpty()) {
                throw new AppException("User Name Is Empty", HttpStatus.BAD_REQUEST);
            }

            EmployeeAttendenceEntity employeeAttendenceEntity = employeeAttendenceMapper.toEmployeeAttendenceEntity(employeeAttendenceDto);
            employeeAttendenceEntity.setAttandenceDate(LocalDate.now());
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

    @Override
    public EmployeeAttendenceDto markEmployeeAttendance(String employeeId) {
        try {
            Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findByEmpNo(employeeId);

            if (!optionalEmployeeEntity.isPresent()) {
                throw new AppException("Employee Does Not Exists", HttpStatus.BAD_REQUEST);
            }
            EmployeeEntity employeeEntity = optionalEmployeeEntity.get();
            LocalDate today = LocalDate.now(ZoneId.of("Asia/Colombo"));
            if(!employeeAttendenceRepository.existsByUsersAndAttandenceDate(employeeEntity.getId().toString(), today)) {
                EmployeeAttendenceEntity employeeAttendenceEntity = new EmployeeAttendenceEntity();
                employeeAttendenceEntity.setAttendenceStatus("Present");
                employeeAttendenceEntity.setUsers(employeeEntity.getId().toString());
                employeeAttendenceEntity.setAttandenceDate(LocalDate.now());
                employeeAttendenceEntity.setRoles(employeeEntity.getRoles());

                EmployeeAttendenceEntity savedEmployeeAttendenceEntity = employeeAttendenceRepository.save(employeeAttendenceEntity);

                return employeeAttendenceMapper.toEmployeeAttendenceDto(savedEmployeeAttendenceEntity);
            }
            return null;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

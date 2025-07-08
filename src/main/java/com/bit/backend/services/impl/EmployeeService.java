package com.bit.backend.services.impl;

import com.bit.backend.dtos.EmployeeDto;
import com.bit.backend.entities.EmployeeEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.EmployeeMapper;
import com.bit.backend.repositories.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceI {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeDto addEmployeeEntity(EmployeeDto employeeDto) {
        try {
            System.out.println("***In Backend***");
            EmployeeEntity employeeEntity = employeeMapper.toEmployeeEntity(employeeDto);
            EmployeeEntity savedItem =  employeeRepository.save(employeeEntity);
            EmployeeDto savedDto = employeeMapper.toEmployeeDto(savedItem);
            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<EmployeeDto> getData() {

        try {
            List<EmployeeEntity>  employeeEntityList = employeeRepository.findAll();
            List<EmployeeDto> employeeDtoList = employeeMapper.toEmployeeDtoList(employeeEntityList);
            return employeeDtoList;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public EmployeeDto updateEmployee(long id, EmployeeDto employeeDto) {

        try {
            Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);

            if (!optionalEmployeeEntity.isPresent()) {
                throw new AppException("Employee Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            EmployeeEntity newEmployeeEntity = employeeMapper.toEmployeeEntity(employeeDto);

            newEmployeeEntity.setId(id);
            EmployeeEntity savedEmployeeEntity = employeeRepository.save(newEmployeeEntity);

            EmployeeDto responseEmployeeDto = employeeMapper.toEmployeeDto(savedEmployeeEntity);
            return responseEmployeeDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    @Override
    public EmployeeDto deleteEmployee(long id) {

        try {
            Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);

            if (!optionalEmployeeEntity.isPresent()) {
                throw new AppException("Employee Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            employeeRepository.deleteById(id);
            return employeeMapper.toEmployeeDto(optionalEmployeeEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

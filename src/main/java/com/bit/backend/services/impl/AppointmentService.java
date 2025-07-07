package com.bit.backend.services.impl;

import com.bit.backend.dtos.AppointmentDto;
import com.bit.backend.entities.AppointmentEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.AppointmentMapper;
import com.bit.backend.repositories.AppointmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService implements AppointmentServiceI{

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    public AppointmentService(AppointmentRepository appointmentRepository, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    public AppointmentDto addAppointmentEntity(AppointmentDto appointmentDto) {
        try {
            System.out.println("***In Backend***");
            AppointmentEntity appointmentEntity = appointmentMapper.toAppointmentEntity(appointmentDto);
            AppointmentEntity savedItem =  appointmentRepository.save(appointmentEntity);
            AppointmentDto savedDto = appointmentMapper.toAppointmentDto(savedItem);
            return savedDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<AppointmentDto> getData() {

        try {
            List<AppointmentEntity> appointmentEntityList = appointmentRepository.findAll();
            List<AppointmentDto> appointmentDtoList = appointmentMapper.toAppointmentDtoList(appointmentEntityList);
            return appointmentDtoList;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public AppointmentDto updateAppointment(long id, AppointmentDto appointmentDto) {

        try {
            Optional<AppointmentEntity> optionalAppointmentEntity = appointmentRepository.findById(id);

            if (!optionalAppointmentEntity.isPresent()) {
                throw new AppException("Appointment Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            AppointmentEntity newAppointmentEntity = appointmentMapper.toAppointmentEntity(appointmentDto);

            newAppointmentEntity.setId(id);
            AppointmentEntity savedAppointmentEntity = appointmentRepository.save(newAppointmentEntity);

            AppointmentDto responseAppointmentDto = appointmentMapper.toAppointmentDto(savedAppointmentEntity);
            return responseAppointmentDto;

        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public AppointmentDto deleteAppointment(long id) {

        try {
            Optional<AppointmentEntity> optionalAppointmentEntity = appointmentRepository.findById(id);

            if (!optionalAppointmentEntity.isPresent()) {
                throw new AppException("Appointment Does Not Exists", HttpStatus.BAD_REQUEST);
            }

            appointmentRepository.deleteById(id);
            return appointmentMapper.toAppointmentDto(optionalAppointmentEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

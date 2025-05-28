package com.bit.backend.controllers;

import com.bit.backend.dtos.AppointmentDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.impl.AppointmentServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class AppointmentController {

    private final AppointmentServiceI appointmentServiceI;

    public AppointmentController(AppointmentServiceI appointmentServiceI) {this.appointmentServiceI = appointmentServiceI;}

    @PostMapping("/appointment")
    public ResponseEntity<AppointmentDto> addAppointment(@RequestBody AppointmentDto appointmentDto) {

        try {
            AppointmentDto appointmentDtoResponse = appointmentServiceI.addAppointmentEntity(appointmentDto);
            return ResponseEntity.created(URI.create("/appointment"+appointmentDtoResponse.getSid())).body(appointmentDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/appointment")
    public ResponseEntity<List<AppointmentDto>> getData() {

        try {
            List<AppointmentDto> appointmentDtoList = appointmentServiceI.getData();
            return ResponseEntity.ok(appointmentDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/appointment/{id}")
    public ResponseEntity<AppointmentDto> updateAppointment(@PathVariable Long id, @RequestBody AppointmentDto appointmentDto) {

        try {
            AppointmentDto responseAppointmentDto = appointmentServiceI.updateAppointment(id, appointmentDto);
            return ResponseEntity.ok(responseAppointmentDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/appointment/{id}")
    public ResponseEntity<AppointmentDto> deleteAppointment(@PathVariable Long id) {

        try {
            AppointmentDto appointmentDto = appointmentServiceI.deleteAppointment(id);
            return ResponseEntity.ok(appointmentDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

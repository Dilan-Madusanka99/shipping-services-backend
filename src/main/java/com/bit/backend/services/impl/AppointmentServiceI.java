package com.bit.backend.services.impl;

import com.bit.backend.dtos.AppointmentDto;

import java.util.List;

public interface AppointmentServiceI {

    AppointmentDto addAppointmentEntity(AppointmentDto appointmentDto);
    List<AppointmentDto> getData();
    AppointmentDto updateAppointment(long id, AppointmentDto appointmentDto);
    AppointmentDto deleteAppointment(long id);
}

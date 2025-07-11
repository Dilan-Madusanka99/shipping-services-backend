package com.bit.backend.services;

import com.bit.backend.dtos.AppointmentDto;
import com.bit.backend.dtos.NotificationDto;
import com.bit.backend.entities.NotificationEntity;
import jakarta.mail.MessagingException;

import java.util.List;

public interface NotificationServiceI {

    NotificationDto addNotification(NotificationDto notificationDto) throws MessagingException;
    List<NotificationDto> getUserNotifications(long id);
    boolean changeNotificationStatus(String id);
    AppointmentDto sendAppointmentNotification(AppointmentDto notificationDto, String message) throws MessagingException;
}

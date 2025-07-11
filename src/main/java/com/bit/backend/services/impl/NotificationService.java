package com.bit.backend.services.impl;

import com.bit.backend.dtos.AppointmentDto;
import com.bit.backend.dtos.NotificationDto;
import com.bit.backend.entities.NotificationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.NotificationMapper;
import com.bit.backend.repositories.NotificationRepository;
import com.bit.backend.services.NotificationServiceI;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class NotificationService implements NotificationServiceI {
    private final NotificationRepository notificationRepository;
    private final NotificationMapper notificationMapper;
    private final JavaMailSender javaMailSender;

    public NotificationService(NotificationRepository notificationRepository, NotificationMapper notificationMapper, JavaMailSender javaMailSender) {
        this.notificationRepository = notificationRepository;
        this.notificationMapper = notificationMapper;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public NotificationDto addNotification(NotificationDto notificationDto) throws MessagingException {
        NotificationEntity notificationEntity = notificationMapper.toNotificationEntity(notificationDto);
        notificationEntity.setTimeStamp(new Date());
        NotificationEntity savedNotification = notificationRepository.save(notificationEntity);
        NotificationDto savedDto = notificationMapper.toNotificationDto(savedNotification);

        String htmlBody = """
    <div style="font-family: Arial, sans-serif;">
        <h2 style="color: #4CAF50;">📢 Carservice Notification </h2>
        <p>Hello Student,</p>
        <p>Your task has been <strong>successfully started</strong>.</p>
        <p>Thank you for using the car service portal.</p>
        <hr>
        <small>This is an automated message. Do not reply.</small>
    </div>
""";

//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setFrom("chamith109mendes@gmail.com"); // CAR SERVICE EMAIL
//        simpleMailMessage.setTo(notificationDto.getEmail());
//        simpleMailMessage.setSubject(notificationDto.getMessage());
//        simpleMailMessage.setText("Your assignment has been uploaded successfully!");

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        helper.setFrom("carservice@gmail.com"); // add the correct mail
        helper.setTo(notificationDto.getEmail());
        helper.setSubject("Demo Email"); // Add correct subject
        helper.setText(htmlBody, true); // Set true for HTML

        if (!notificationDto.getEmail().isEmpty()) {
            javaMailSender.send(mimeMessage);
        }

        return savedDto;
    }

    @Override
    public List<NotificationDto> getUserNotifications(long id) {
        String idString = Long.toString(id);
        List<NotificationEntity> notificationEntityList = notificationRepository.getUserNotification(idString);
        List<NotificationDto> notificationDtoList = notificationMapper.toNotificationDtoList(notificationEntityList);
        return notificationDtoList;
    }

    @Override
    public boolean changeNotificationStatus(String id) {
        Long notificationId = Long.parseLong(id);

        try {
            Optional<NotificationEntity> optionalNotificationEntity = notificationRepository.findById(notificationId);

            if (!optionalNotificationEntity.isPresent()) {
                throw new AppException("Can't update notification status", HttpStatus.BAD_REQUEST);
            }

            NotificationEntity oldNotificationEntity = optionalNotificationEntity.get();
            oldNotificationEntity.setReadStatus(true);
            NotificationEntity updatedNotificationEntity = notificationRepository.save(oldNotificationEntity);
            if (updatedNotificationEntity.isReadStatus() == true) {
                return true;
            } else return false;
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public AppointmentDto sendAppointmentNotification(AppointmentDto notificationDto, String message) throws MessagingException {
        String inputDateStr = notificationDto.getAppointmentDate();
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(inputDateStr);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        String formattedDate = zonedDateTime.format(dateFormatter);
        String htmlBody = "";
        if (message.equals("schedule")) {
            htmlBody = """
    <div style="font-family: Arial, sans-serif; padding: 20px; color: #333;">
      <h1 style="color: #003366; margin-bottom: 5px;">V W Shipping Services Pvt Ltd</h1>
      <hr style="border: none; height: 2px; background-color: #4CAF50; margin-bottom: 20px;">

      <h2 style="color: #4CAF50;">✅ Appointment Scheduled Successfully</h2>
      <p>Dear """ + " " + notificationDto.getFirstName() + " " + notificationDto.getLastName() + """
      ,</p>

      <p>Your appointment has been <strong>successfully scheduled</strong>.</p>

      <p><strong>Date:</strong> """
                    + formattedDate + """
         <br>
         <strong>Time:</strong> """ + notificationDto.getAppointmentTime() + """
      </p>

      <p>Please be on time and bring any necessary documents.</p>

      <hr style="margin: 30px 0;">

      <p style="font-size: 12px; color: #888;">
        This is an automated message from the university system powered by V W Shipping Services Pvt Ltd. Please do not reply.
      </p>
    </div>
""";
        } else if (message.equals("reschedule")) {
            htmlBody = """
    <div style="font-family: Arial, sans-serif; padding: 20px; color: #333;">
      <h1 style="color: #003366; margin-bottom: 5px;">V W Shipping Services Pvt Ltd</h1>
      <hr style="border: none; height: 2px; background-color: #4CAF50; margin-bottom: 20px;">

      <h2 style="color: #4CAF50;">✅ Appointment rescheduled Successfully</h2>
      <p>Dear """ + " " + notificationDto.getFirstName() + " " + notificationDto.getLastName() + """
      </p>

      <p>Your appointment has been <strong>successfully rescheduled</strong>.</p>

      <p><strong>Date:</strong> """
                    + formattedDate + """
         <br>
         <strong>Time:</strong> """ + notificationDto.getAppointmentTime() + """
      </p>

      <p>Please be on time and bring any necessary documents.</p>

      <hr style="margin: 30px 0;">

      <p style="font-size: 12px; color: #888;">
        This is an automated message from the university system powered by V W Shipping Services Pvt Ltd. Please do not reply.
      </p>
    </div>
""";
        }

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        helper.setFrom("dilanfenando123@gmail.com"); // add the correct mail
        helper.setTo(notificationDto.getEmail());
        helper.setSubject("V W Shipping Services Pvt Ltd - Appointment " + message); // Add correct subject
        helper.setText(htmlBody, true); // Set true for HTML

        if (!notificationDto.getEmail().isEmpty()) {
            javaMailSender.send(mimeMessage);
        }

        return notificationDto;
    }
}

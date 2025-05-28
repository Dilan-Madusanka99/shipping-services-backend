package com.bit.backend.dtos;

public class AppointmentDto {

    private Long id;
    private String sid;
    private String firstName;
    private String lastName;
    private String position;
    private String appointmentDate;
    private String appointmentTime;

    public AppointmentDto() {
    }

    public AppointmentDto(Long id, String sid, String firstName, String lastName, String position, String appointmentDate, String appointmentTime) {
        this.id = id;
        this.sid = sid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
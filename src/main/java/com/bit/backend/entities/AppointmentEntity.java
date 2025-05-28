package com.bit.backend.entities;


import jakarta.persistence.*;

@Entity
@Table(name="appointment")

public class AppointmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "sid")
    private String sid;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "position")
    private String position;

    @Column(name = "appointmentDate")
    private String appointmentDate;

    @Column(name = "appointmentTime")
    private String appointmentTime;

    public AppointmentEntity() {
    }

    public AppointmentEntity(Long id, String sid, String firstName, String lastName, String position, String appointmentDate, String appointmentTime) {
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

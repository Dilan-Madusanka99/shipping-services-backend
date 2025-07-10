package com.bit.backend.entities;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table (name = "employee_attendence")
public class EmployeeAttendenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "users")
    private String users;

    @Column(name = "attendenceStatus")
    private String attendenceStatus;

    @Column(name = "userName")
    private String userName;

    @Column(name = "roles")
    private String roles;

    @Column(name = "attandenceDate")
    private LocalDate attandenceDate = LocalDate.now();

    public EmployeeAttendenceEntity() {
    }

    public EmployeeAttendenceEntity(Long id, String users, String attendenceStatus, String userName, String roles, LocalDate attandenceDate) {
        this.id = id;
        this.users = users;
        this.attendenceStatus = attendenceStatus;
        this.userName = userName;
        this.roles = roles;
        this.attandenceDate = attandenceDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getAttendenceStatus() {
        return attendenceStatus;
    }

    public void setAttendenceStatus(String attendenceStatus) {
        this.attendenceStatus = attendenceStatus;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public LocalDate getAttandenceDate() {
        return attandenceDate;
    }

    public void setAttandenceDate(LocalDate attandenceDate) {
        this.attandenceDate = attandenceDate;
    }
}

package com.bit.backend.dtos;

import java.time.LocalDate;

public class EmployeeAttendenceDto {

    private Long id;
    private String users;
    private String attendenceStatus;
    private String userName;
    private String roles;
    private LocalDate attandenceDate;

    public EmployeeAttendenceDto() {
    }

    public EmployeeAttendenceDto(Long id, String users, String attendenceStatus, String userName, String roles, LocalDate attandenceDate) {
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

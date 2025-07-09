package com.bit.backend.dtos;

import java.time.LocalDate;
import java.util.Date;

public class EmployeeAttendenceDto {

    private Long id;
    private String users;
    private String attendenceStatus;
    private String userName;
    private LocalDate attandenceDate;

    public EmployeeAttendenceDto() {
    }

    public EmployeeAttendenceDto(Long id, String users, String attendenceStatus, String userName, LocalDate attandenceDate) {
        this.id = id;
        this.users = users;
        this.attendenceStatus = attendenceStatus;
        this.userName = userName;
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

    public LocalDate getAttandenceDate() {
        return attandenceDate;
    }

    public void setAttandenceDate(LocalDate attandenceDate) {
        this.attandenceDate = attandenceDate;
    }
}

package com.bit.backend.dtos;

import java.util.Date;

public class StandbyCrewMembersDto {

    private Long id;
    private String sidNo;
    private String position;
    private String status;

    public StandbyCrewMembersDto() {
    }

    public StandbyCrewMembersDto(Long id, String sidNo, String position, String status) {
        this.id = id;
        this.sidNo = sidNo;
        this.position = position;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSidNo() {
        return sidNo;
    }

    public void setSidNo(String sidNo) {
        this.sidNo = sidNo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package com.bit.backend.dtos;

public class PrivilegeGroupDto {

    public PrivilegeGroupDto() {}

    public PrivilegeGroupDto(Long id, String groupName, String groupDescription, int status, int seafarerDefault) {
        this.id = id;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.status = status;
        this.seafarerDefault = seafarerDefault;
    }

    private Long id;
    private String groupName;
    private String groupDescription;
    int status;
    int seafarerDefault;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSeafarerDefault() {
        return seafarerDefault;
    }

    public void setSeafarerDefault(int seafarerDefault) {
        this.seafarerDefault = seafarerDefault;
    }
}

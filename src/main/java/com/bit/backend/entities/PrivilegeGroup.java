package com.bit.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "auth_groups")
public class PrivilegeGroup {

    public PrivilegeGroup() {}

    public PrivilegeGroup(Long id, String groupName, String groupDescription, int status, int seafarerDefault) {
        this.id = id;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.status = status;
        this.seafarerDefault = seafarerDefault;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "group_description")
    private String groupDescription;

    @Column(name = "status")
    private int status;

    @Column(name = "seafarer_default", columnDefinition = "int default 0")
    private int seafarerDefault;

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

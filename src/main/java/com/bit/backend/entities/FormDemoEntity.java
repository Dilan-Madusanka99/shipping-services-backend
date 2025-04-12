package com.bit.backend.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "form_Demo")

public class FormDemoEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "firstName")
    private String firstName;

    @Column (name = "lastName")
    private String lastName;

    @Column (name = "email")
    private String email;

    @Column (name = "age")
    private int age;


    public FormDemoEntity() {
    }

    public FormDemoEntity(Long id, String firstName, String lastName, String email, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    // meke getters dala na. settets witharai


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

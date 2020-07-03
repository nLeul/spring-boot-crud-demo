package com.leul.restservice.model;

import org.springframework.stereotype.Component;

import java.util.UUID;

public class Student {
    private  UUID id;
    private final String firstName;
    private final String lastName;
    private final String course;

    public Student(UUID id, String firstName, String lastName, String course) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCourse() {
        return course;
    }
}

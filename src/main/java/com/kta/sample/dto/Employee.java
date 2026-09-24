package com.kta.sample.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    public final Long id;
    private final String firstName;
    private final String lastName;
    //private String email;

    public Employee(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /*public Employee(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }*/
}

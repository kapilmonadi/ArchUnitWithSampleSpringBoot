package com.kta.sample.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 5050L;

    private Long id;
    private String firstName;
    private String lastName;
}

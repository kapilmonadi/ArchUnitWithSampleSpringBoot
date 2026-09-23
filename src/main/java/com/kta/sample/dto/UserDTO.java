package com.kta.sample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Deprecated
@Data
@AllArgsConstructor
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;

}

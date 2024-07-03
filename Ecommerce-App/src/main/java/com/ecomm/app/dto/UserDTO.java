package com.ecomm.app.dto;

import jakarta.persistence.Transient;
import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String password;
    @Transient
    private List<String> roles;
}

package com.kodigo.solid.registration;

import lombok.*;


@Setter
@Getter
public class Registration {
    private String dui;
    private String name;
    private String dateOfBirth;
    private int phoneNumber;
    private String email;

    // constructor vacio
    public Registration() {
    }

    public Registration(String dui, String name, String dateOfBirth, int phoneNumber, String email) {
        this.dui = dui;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}




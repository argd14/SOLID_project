package com.kodigo.solid.entities;

import java.time.LocalDate;


public class DoctorEntity extends UserEntity {

    public DoctorEntity(int id, String username, String name, LocalDate birthday, String phoneNumber, String email, String password, int role) {
        super(id, username, name, birthday, phoneNumber, email, password, role);
    }
}
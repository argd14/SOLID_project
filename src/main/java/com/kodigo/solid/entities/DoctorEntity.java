package com.kodigo.solid.entities;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data

public class DoctorEntity extends UserEntity {

    public DoctorEntity() {
    }

    public DoctorEntity(int id, String username, String name, LocalDate birthday, String phoneNumber, String email, String password, int role) {
        super(id, username, name, birthday, phoneNumber, email, password, role);
    }

    public DoctorEntity(String name, LocalDate parse, String phone, String email, String password) {
    }
}
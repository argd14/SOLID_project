package com.kodigo.solid.entities;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data

public class AdminEntity extends UserEntity implements Serializable, Entity {

    public AdminEntity() {
    }

    public AdminEntity(int id, String username, String name, LocalDate birthday, String phoneNumber, String email, String password, int role) {
        super(id, username, name, birthday, phoneNumber, email, password, role);
    }
}

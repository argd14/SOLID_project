package com.kodigo.solid.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data

public class Admin extends UserEntity implements Serializable , Entity {

    public Admin() {
    }

    public Admin(int id, String username, String name, LocalDate birthday, String phoneNumber, String email, String password, int role) {
        super(id, username, name, birthday, phoneNumber, email, password, role);
    }
}

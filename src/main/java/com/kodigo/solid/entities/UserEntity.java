package com.kodigo.solid.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@NoArgsConstructor
public class UserEntity extends BaseEntity {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String Username;
    private String name;
    private LocalDate birthday;
    private String phoneNumber;
    private String email;
    private String password;
    private int Role;

    public UserEntity(int id, int id1, String username, String name, LocalDate birthday, String phoneNumber, String email, String password, int role) {
        super(id);
        this.id = id1;
        Username = username;
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        Role = role;
    }

    @Override
    public String toString() {
        return "\nUsuario: " + "nombre: " + name + '\'' + " fecha de nacimiento: " + birthday + " numero de telefono: " + phoneNumber + '\'' + " correo electronico: " + email;
    }
}




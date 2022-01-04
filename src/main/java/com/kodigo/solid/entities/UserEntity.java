package com.kodigo.solid.entities;

import lombok.Getter;

import java.time.LocalDate;


public class UserEntity extends BaseEntity {


    @Getter
    private String username;
    @Getter
    private String name;
    @Getter
    private LocalDate birthday;
    @Getter
    private String phoneNumber;
    @Getter
    private String email;
    @Getter
    private String password;
    @Getter
    private int role;

    public UserEntity(int id, String username, String name, LocalDate birthday, String phoneNumber, String email, String password, int role) {
        super(id);
        this.username = username;
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "\nUsuario: " + "nombre: " + name + '\'' + " fecha de nacimiento: " + birthday + " numero de telefono: " + phoneNumber + '\'' + " correo electronico: " + email;
    }
}




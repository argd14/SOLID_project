package com.kodigo.solid.entities;

import java.time.LocalDate;


public class UserEntity extends BaseEntity {


    private String Username;
    private String name;
    private LocalDate birthday;
    private String phoneNumber;
    private String email;
    private String password;
    private int Role;

    public UserEntity(int id, String username, String name, LocalDate birthday, String phoneNumber, String email, String password, int role) {
        super(id);
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




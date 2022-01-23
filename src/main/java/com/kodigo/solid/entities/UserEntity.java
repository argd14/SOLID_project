package com.kodigo.solid.entities;

import jdk.jfr.ContentType;
import lombok.*;
import org.intellij.lang.annotations.JdkConstants;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    private static final AtomicInteger count = new AtomicInteger(0);

    private Long id;
    private String username;
    private String name;
    private LocalDate birthday;
    private String phoneNumber;
    private String email;
    private String password;
    private int Role;

    @Override
    public String toString() {
        return "\nUsuario: " + "nombre: " + name + '\'' + " fecha de nacimiento: " + birthday + " numero de telefono: " + phoneNumber + '\'' + " correo electronico: " + email;
    }
}




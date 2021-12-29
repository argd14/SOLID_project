package com.kodigo.solid.entities;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@NoArgsConstructor
public class UserEntity {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String Username;
    private String name;
    private LocalDate birthday;
    private String phoneNumber;
    private String email;
    private String password;
    private int Role;

    public UserEntity(int id, String username, String name, LocalDate birthday, String phoneNumber, String email, String password, int role) {
        this.id = id;
        this.Username = username;
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.Role = role;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", Username='" + Username + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", Role=" + Role +
                '}';
    }
}




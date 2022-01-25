package com.kodigo.solid.fakeRepository;

import com.kodigo.solid.entities.UserEntity;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;

@Data
public class FakeUsersDb {


    public ArrayList<UserEntity> userDatabase() {
        ArrayList<UserEntity> users = new ArrayList<>();
        UserEntity admin = UserEntity.builder()
                .id(11L)
                .username("Admin")
                .name("admin")
                .birthday(LocalDate.parse("1985-11-11"))
                .phoneNumber("77895641")
                .email("admin@admin.com")
                .password("admin")
                .Role(1)
                .build();

        users.add(admin);

        UserEntity patient1 = UserEntity.builder()
                .id(12L)
                .username("Roxy")
                .name("roxy")
                .birthday(LocalDate.parse("1998-05-11"))
                .phoneNumber("77895641")
                .email("roxy@gmail.com")
                .password("1234")
                .Role(3)
                .build();
        users.add(patient1);

        UserEntity patient2 = UserEntity.builder()
                .id(14L)
                .username("Juan")
                .name("juan")
                .birthday(LocalDate.parse("1998-05-11"))
                .phoneNumber("77895641")
                .email("juan@gmail.com")
                .password("1234")
                .Role(3)
                .build();
        users.add(patient2);

        UserEntity doctor = UserEntity.builder()
                .id(15L)
                .username("Rivas")
                .name("rivas")
                .birthday(LocalDate.parse("1973-10-08"))
                .phoneNumber("77895641")
                .email("doctorrivas@gmail.com")
                .password("1234")
                .Role(2)
                .build();
        users.add(doctor);

        return users;
    }


}

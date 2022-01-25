package com.kodigo.solid.controllers;

import com.kodigo.solid.entities.AppointmentEntity;
import com.kodigo.solid.entities.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AdminControllerTest {

    AdminEntityController adminEntityController;
    List<UserEntity> userEntityList;
    UserEntity user;

    @BeforeEach
    public void setup() {
        adminEntityController = new AdminEntityController();
        userEntityList = adminEntityController.fakeUsers.userDatabase();
        user = UserEntity.builder()
                .id(11L)
                .username("Admin")
                .name("admin")
                .birthday(LocalDate.parse("1985-11-11"))
                .phoneNumber("77895641")
                .email("admin@admin.com")
                .password("admin")
                .Role(1)
                .build();
    }

    @Test
    @DisplayName("Method createUser - Should add new user to userList")
    void createUser() {
        userEntityList.add(user);
    assertTrue(userEntityList.contains(user));
    }

    @Test
    @DisplayName("Method updateUserName - Should update username")
    void updateUserName() {
        user.setName("New Name");
        assertEquals("New Name", user.getName());
    }

    @Test
    @DisplayName("Method deleteUser - Should remove new user from userList")
    void deleteUser() {
        userEntityList.remove(user);
        assertFalse(userEntityList.contains(user));
    }

    @Test
    @DisplayName("Method lisAllUsers - Should return a list with all users")
    void lisAllUsers() {
        assertFalse(userEntityList.isEmpty());
        assertEquals(4, userEntityList.size());
    }



}
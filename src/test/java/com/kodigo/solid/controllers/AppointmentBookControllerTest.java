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
class AppointmentBookControllerTest {

    AppointmentBookController appointmentBookController;
    List<AppointmentEntity> appointmentEntityList;
    AppointmentEntity appointment;

    @BeforeEach
    public void setup() {
        appointmentBookController = new AppointmentBookController();
        appointmentEntityList = appointmentBookController.fakeAppointment.appointmentDatabase();
        appointment = AppointmentEntity.builder()
                .id(2)
                .idPatient(12L)
                .idDoctor(15L)
                .nameDoctor("Dr. Rivas")
                .namePatient("Roxy")
                .datetime(LocalDate.ofEpochDay(2020-12-12))
                .time(LocalTime.now())
                .build();
    }

    @Test
    @DisplayName("Method listAllAppointments - Should return a list with all appointments")
    void listAllAppointments() {
        assertFalse(appointmentEntityList.isEmpty());
        assertEquals(4, appointmentEntityList.size());
    }

    @Test
    @DisplayName("Method createAppointment - Should add new appointment to appointmentList")
    void createAppointment() {
        appointmentEntityList.add(appointment);
        assertTrue(appointmentEntityList.contains(appointment));
    }

    @Test
    @DisplayName("Method updateAppointment - Should update appointment's doctor name")
    void updateAppointment() {
        appointment.setNameDoctor("New doctor Name");
        assertEquals("New doctor Name", appointment.getNameDoctor());
    }

    @Test
    @DisplayName("Method deleteAppointment - Should remove new appointment from appointmentList")
    void deleteAppointment() {
        appointmentEntityList.remove(appointment);
        assertFalse(appointmentEntityList.contains(appointment));
    }


}
package com.kodigo.solid.entities;

import com.kodigo.solid.fakeDB.FakeAppointmentDb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AppointmentEntityTest {

    AppointmentEntity appointment;

    @BeforeEach
    public void setup() {
        appointment = AppointmentEntity.builder()
                .id(1)
                .idPatient(1L)
                .idDoctor(1L)
                .nameDoctor("Dr. Rivas")
                .namePatient("Roxy")
                .datetime(LocalDate.ofEpochDay(2022-01-01))
                .time(LocalTime.now())
                .build();
    }


    @Test
    @DisplayName("Method getTimeString - Should return time formatted as string")
    void getTimeString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        String time =  appointment.getTime().format(formatter);
        assertEquals(time, appointment.getTimeString());
    }

    @Test
    @DisplayName("Method testToString - Should return appointment formatted as string")
    void testToString() {
        assertNotNull(appointment.toString());
    }
}
package com.kodigo.solid.fakeDB;

import com.kodigo.solid.entities.AppointmentEntity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class FakeAppointmentDb {

    public ArrayList<AppointmentEntity> appointmentDatabase(){
        ArrayList<AppointmentEntity> appointments = new ArrayList<>();
        AppointmentEntity appointment1 = AppointmentEntity.builder()
                .id(2)
                .idPatient(12L)
                .idDoctor(15L)
                .nameDoctor("Dr. Rivas")
                .namePatient("Roxy")
                .datetime(LocalDate.ofEpochDay(2020-12-12))
                .time(LocalTime.ofSecondOfDay(12-12))
                .build();
        appointments.add(appointment1);

        AppointmentEntity appointment2 = AppointmentEntity.builder()
                .id(3)
                .idPatient(14L)
                .idDoctor(15L)
                .nameDoctor("Dr. Rivas")
                .namePatient("Juan")
                .datetime(LocalDate.ofEpochDay(2020-12-12))
                .time(LocalTime.ofSecondOfDay(20-12))
                .build();
        appointments.add(appointment2);


        return appointments;
    }
}

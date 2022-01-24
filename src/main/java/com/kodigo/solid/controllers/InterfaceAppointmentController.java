package com.kodigo.solid.controllers;

import com.kodigo.solid.entities.AppointmentEntity;
import com.kodigo.solid.entities.UserEntity;

import java.time.LocalDate;

public interface InterfaceAppointmentController {

    AppointmentEntity getAppointment(int id);

    void listAllAppointments(Long id);

    void createAppointment();

    void updateAppointment(AppointmentEntity appointment);

    void deleteAppointment(int id);


    void writeFile();
}

package com.kodigo.solid.controllers;

import java.time.LocalDate;

public interface InterfaceAppointmentController {

     void listPatientAppointments(int id, String name);
     void addAppointment(int id, String name);
     void updateAppointment();
     void deleteAppointment(int id);

     void sortFileByDate();
}

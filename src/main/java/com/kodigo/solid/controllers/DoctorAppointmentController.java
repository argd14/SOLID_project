package com.kodigo.solid.controllers;

import java.io.BufferedReader;
import java.io.FileReader;

public class DoctorAppointmentController implements InterfaceDoctorAppointmentController {
    @Override
    public void showAllAppointment() {
        try {
            String linea ;
            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\angel\\IdeaProjects\\SOLID_project\\fileAppointment.text"));
            linea = bf.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = bf.readLine();
            }

        } catch (Exception e) {

            System.err.println("error -->" + e.getMessage());
        }

    }
}

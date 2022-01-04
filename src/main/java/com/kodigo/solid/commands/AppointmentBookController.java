package com.kodigo.solid.commands;

import com.kodigo.solid.entities.*;
import lombok.Data;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

@Data
public class AppointmentBookController {
    private List<AppointmentEntity> appointments = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private AdminEntityController listUser;
    private AppointmentEntity appointment;

    public void addAppointmentEntity(int id, String name) {
        System.out.println("\nIngrese los datos de la cita");
        System.out.println("Ingrese Fecha:");
        LocalDate d = LocalDate.parse(sc.next());
        System.out.println("Ingrese Hora:");
        LocalTime t = LocalTime.parse(sc.next());

        appointment = new AppointmentEntity(id, name, d, t);
        appointments.add(appointment);
        fileWrite();

    }

    public void fileWrite() {
        try {

            File directory = new File(".");
            File fileAppointment = new File(directory, "fileAppointment.text");
            FileWriter write = new FileWriter(fileAppointment);
            BufferedWriter writeBuff = new BufferedWriter(write);

            for (int i = 0; i < appointments.size(); i++) {
                writeBuff.write("\nId usuario: " + appointments.get(i).getPatientId() +
                        "\nFecha de cita: " + appointments.get(i).getDate() +
                        "\nHora de la cita: " + appointments.get(i).getTime());

            }

            System.out.println("\nCita añadida exitosamente\n");
            writeBuff.close();
        } catch (Exception e) {

            System.out.println("Error -->" + e.getMessage());
        }
    }

    public void updateAppointmentEntity() {

        System.out.println("Ingrese nueva fecha:");
        appointment.setDate(LocalDate.parse(sc.next()));
        System.out.println("Ingrese nueva hora:");
        appointment.setTime(LocalTime.parse(sc.next()));
        System.out.println("¡Cita actualizada exitosamente!");

    }

    public void ShowAppointmentsEntity() {
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

    public void listAppointmentsByDay(LocalDate date) {
        appointments.sort(Comparator.comparing(AppointmentEntity::getDatetime));
        for (AppointmentEntity a : appointments) {
            if (a != null && a.getDate().equals(date)) {
                System.out.println("Citas de Hoy");
                System.out.println(a.toString());
            } else {
                System.out.println("No hay citas para hoy");
            }
        }
    }

    public void listPatientAppointments(int id, String name) {
       // appointments.sort(Comparator.comparing(AppointmentEntity::getDatetime));

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

    public void deleteAppointmentEntity(LocalDate date) {


        for (int i = 1; i <= appointments.size(); i++) {
            if (date.equals(appointments.get(i).getDate())) {
                appointments.remove(i);
            } else {
                System.out.println("Número de cita no encontrado");
            }
        }


    }

}


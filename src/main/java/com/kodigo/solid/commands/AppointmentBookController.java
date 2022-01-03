package com.kodigo.solid.commands;

import com.kodigo.solid.entities.*;
import lombok.Data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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
    private AppointmentEntity appointment;

    public void addAppointmentEntity(int id) {
        System.out.println("\nIngrese los datos de la cita");
        System.out.println("Ingrese Fecha");
        LocalDate d = LocalDate.parse(sc.next());
        System.out.println("Ingrese Hora");
        LocalTime t = LocalTime.parse(sc.next());
        appointment = new AppointmentEntity(id, d, t);
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

        System.out.println("Ingrese nueva fecha");
        appointment.setDate(LocalDate.parse(sc.next()));
        System.out.println("Ingrese nueva hora");
        appointment.setTime(LocalTime.parse(sc.next()));
        System.out.println("Cita actualizada exitosamente");

    }

    public void listAppointments() {
        appointments.sort(Comparator.comparing(AppointmentEntity::getDatetime));
        for (AppointmentEntity a : appointments) {
            if (a != null) {
                System.out.println(a.toString());
            }
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

    public void listPatientAppointments(int id) {
        appointments.sort(Comparator.comparing(AppointmentEntity::getDatetime));
        for (AppointmentEntity a : appointments) {
            if (a != null && a.getPatientId() == id) {
                System.out.println(a);
            }
        }
    }

    public void deleteAppointmentEntity(LocalDate date) {


        for (int i = 1; i <= appointments.size(); i++) {
            if (date.equals(appointments.get(i).getDate())) {
                appointments.remove(i);
            } else {
                System.out.println("numero de cita no encontrado");
            }
        }


    }

}

   /* public void update(AppointmentEntity a, LocalDate date, LocalTime time){
        if (Appointments.contains(a))
        {
            a.setDate(date);
            a.setTime(time);
            a.setDatetime(date.atTime(time));
            System.out.println("Updated appointment " + a.toString());
        }
        else
            System.out.println("Appointment not found");
    }
}
*/
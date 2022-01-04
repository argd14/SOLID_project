package com.kodigo.solid.controllers;

import com.kodigo.solid.entities.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static javax.swing.UIManager.get;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentBookController extends AbstractAppointmentController{
    private Scanner sc = new Scanner(System.in);
    private AppointmentEntity appointment;

    @Override
    public void listPatientAppointments(int id, String name) {
        try {
            String linea;
            BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\angel\\IdeaProjects\\SOLID_project\\fileAppointment.text"));
            linea = bf.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = bf.readLine();
            }

        } catch (Exception e) {

            System.err.println("error -->" + e.getMessage());
        }
        sortFileByDate();
        for(int i = 0; i< appointments.size(); i++){
            if(id== appointments.get(i).getId()){
                System.out.println("\nID: "+ id+
                                    "\nNombre :"+ name+
                                    "\nFecha: "+ appointments.get(i).getDate()+
                                    "\nHora: "+ appointments.get(i).getTime());
            }

        }

    }

    @Override
    public void addAppointment(int id, String name) {
        System.out.println("\nIngrese los datos de la cita");
        System.out.println("Ingrese Fecha");
        LocalDate d = LocalDate.parse(sc.next());
        System.out.println("Ingrese Hora");
        LocalTime t = LocalTime.parse(sc.next());
        System.out.println(id);
        appointment = new AppointmentEntity(id, d, t);
        appointments.add(appointment);
        writeFile();
    }

    @Override
    public void updateAppointment() {
        System.out.println("Ingrese nueva fecha");
        appointment.setDate(LocalDate.parse(sc.next()));
        System.out.println("Ingrese nueva hora");
        appointment.setTime(LocalTime.parse(sc.next()));
        System.out.println("Cita actualizada exitosamente");
    }

    @Override
    public void deleteAppointment(int id) {
        //System.out.println(i);
      for (int i = 0; i < appointments.size(); i++) {
            if (id == appointments.get(i).getId() ) {
                appointments.remove(i);
                System.out.println("¡Cita eliminada exitosamente!\n");
            }
        }
    }

    @Override
    public void writeFile() {
        try {

            File directory = new File(".");
            File fileAppointment = new File(directory, "fileAppointment.text");
            FileWriter write = new FileWriter(fileAppointment);
            BufferedWriter writeBuff = new BufferedWriter(write);

            for (int i = 0; i < appointments.size(); i++) {
                writeBuff.write("\nId usuario: " + appointments.get(i).getId() +
                        "\nFecha de cita: " + appointments.get(i).getDate() +
                        "\nHora de la cita: " + appointments.get(i).getTime());

            }

            System.out.println("\nCita añadida exitosamente\n");
            writeBuff.close();
        } catch (Exception e) {

            System.out.println("Error -->" + e.getMessage());
        }
    }

    @Override
    public void sortFileByDate(){
        appointments.sort(Comparator.comparing(AppointmentEntity::getDatetime));
    }
}


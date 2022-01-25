package com.kodigo.solid.controllers;

import com.kodigo.solid.entities.*;
import com.kodigo.solid.fakeRepository.FakeAppointmentDb;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;

@Data
@RequiredArgsConstructor
public class AppointmentBookController extends AbstractAppointmentController {
    private Scanner sc = new Scanner(System.in);
    private Long idAuth;
    private Integer rolAuth;
    private String nameAuth;

    //Dependencia
    private FakeAppointmentDb fakeAppointment = new FakeAppointmentDb();

    @Override
    public void loadDatabase() {
        appointments = fakeAppointment.appointmentDatabase();
    }


    @Override
    public AppointmentEntity getAppointment(int id) {
        for (int i = 0; i < appointments.size(); i++) {
            if (id == appointments.get(i).getId()) {
                return appointments.get(i);
            }
        }
        return null;
    }

    @Override
    public void listAllAppointments(Long id) {
        if (rolAuth.equals(3)) {
            for (int i = 0; i < appointments.size(); i++) {
                if (id == appointments.get(i).getIdPatient()) {
                    System.out.println(appointments.get(i));
                }
            }
        } else if (rolAuth.equals(2)) {
            for (int i = 0; i < appointments.size(); i++) {
                if (id == appointments.get(i).getIdDoctor()) {
                    System.out.println(appointments.get(i));
                }
            }

        }
    }

    //metodo nuevo
    @Override
    public void createAppointment() {
        Random ram = new Random();
        int id = ram.nextInt(2000);
        if (rolAuth.equals(2)) {
            System.out.println("\nIngrese los datos de la cita");
            System.out.println("Ingrese el nombre del paciente");
            String name = sc.nextLine();
            System.out.println("Ingrese la fecha de la cita");
            LocalDate d = LocalDate.parse(sc.next());
            System.out.println("Ingrese la hora de la cita");
            LocalTime t = LocalTime.parse(sc.next());
            System.out.println("El registro fue creado exitosamente\n");
            AppointmentEntity appointment = new AppointmentEntity(id, name, this.nameAuth, this.idAuth, d, t);
            appointments.add(appointment);
        } else if (rolAuth.equals(3)) {
            System.out.println("\nIngrese los datos de la cita");
            System.out.println("Ingrese el nombre del doctor");
            String name = sc.nextLine();
            System.out.println("Ingrese la fecha de la cita");
            LocalDate d = LocalDate.parse(sc.next());
            System.out.println("Ingrese la hora de la cita");
            LocalTime t = LocalTime.parse(sc.next());
            System.out.println("El registro fue creado exitosamente\n");
            AppointmentEntity appointment = new AppointmentEntity(id, d, t, this.nameAuth, name, this.idAuth);
            appointments.add(appointment);
        }

    }

    @Override
    public void updateAppointment(@NotNull AppointmentEntity appointment) {
        AppointmentEntity appointmentDB = getAppointment(appointment.getId());
        for (int i = 0; i < appointments.size(); i++) {
            if (appointments.get(i) == appointmentDB) {
                System.out.println("Ingrese nueva fecha");
                appointment.setDatetime(LocalDate.parse(sc.next()));
                System.out.println("Ingrese nueva hora");
                appointment.setTime(LocalTime.parse(sc.next()));
                System.out.println("Cita actualizada exitosamente");
                appointments.set(i, appointmentDB);
            }
        }
    }

    @Override
    public void deleteAppointment(int id) {
        //System.out.println(i);
        for (int i = 0; i < appointments.size(); i++) {
            if (id == appointments.get(i).getId()) {
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
                        "\nFecha de cita: " + appointments.get(i).getDatetime() +
                        "\nHora de la cita: " + appointments.get(i).getTime());

            }

            System.out.println("\nCita añadida exitosamente\n");
            writeBuff.close();
        } catch (Exception e) {

            System.out.println("Error -->" + e.getMessage());
        }
    }

}


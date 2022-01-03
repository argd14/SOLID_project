package com.kodigo.solid.services.auth;

import com.kodigo.solid.database.Database;
import com.kodigo.solid.entities.AppointmentEntity;
import com.kodigo.solid.entities.ConsulationEntity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

public class ConsultationService {
   /* private Database database = new Database();
    private AppointmentEntity;


    public void showAll() {

        System.out.println("Consultas disponibles");

        var availableConsultations = this.database.newConsultations;
        for (ConsulationEntity consulation : availableConsultations) {

            StringBuilder builder = new StringBuilder();
            builder.append("Consulta ID: ");
            builder.append(consulation.getId());
            builder.append(", FECHA: ");
            builder.append(consulation.getConsultationDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));

            System.out.println(builder);
        }
    }

    public void createConsultation() {
        System.out.println("Citas en cola");
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

        System.out.println("\nIngrese los datos de la cita");
        System.out.println("Ingrese Fecha");
        LocalDate d = LocalDate.parse(sc.next());
        System.out.println("Ingrese Hora");
        LocalTime t = LocalTime.parse(sc.next());
        appointment = new AppointmentEntity(id, d, t);
        appointments.add(appointment);
        fileWrite();


        Scanner input = new Scanner(System.in);
        var availableAppoiments = this.database.getAppoiments();

        for (AppointmentEntity appointment : availableAppoiments) {
            StringBuilder builder = new StringBuilder();
            builder.append("Cita ID: ");
            builder.append(appointment.getPatientId());
            builder.append(", FECHA: ");
            builder.append(appointment.getDate().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
            builder.append(" HORA: ");
            builder.append(appointment.getTime().format(DateTimeFormatter.ofPattern("HH:mm")));

            System.out.println(builder);
        }

        System.out.println("Ingrese Cita ID > ");
        int appoimentId = input.nextInt();
        input.nextLine();
        System.out.println("Fecha que desea registrar la consulta (yyyy-mm-dd) > ");
        String date = input.nextLine();

        System.out.println(date);
        System.out.println(LocalDate.parse(date));
        var consultation = new ConsulationEntity(this.database.newConsultations.size() + 1, availableAppoiments.get(appoimentId), LocalDate.parse(date));
        this.database.newConsultations.add(consultation);
        System.out.println("Consulta Registrada.");
    }*/
}
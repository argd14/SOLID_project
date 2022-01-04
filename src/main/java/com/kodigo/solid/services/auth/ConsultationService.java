package com.kodigo.solid.services.auth;

import fkDatabase.Database;
import com.kodigo.solid.entities.AppointmentEntity;
import com.kodigo.solid.entities.ConsulationEntity;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;

public class ConsultationService {
    private Database database = new Database();

    public void showAppointmentEntity() {
        System.out.println("Consultas Actualmente en cola");
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

    public void createConsultation() {
        System.out.println("Citas disponibles");
        Scanner input = new Scanner(System.in);
        var availableAppoiments = this.database.getAppoiments();

        for (AppointmentEntity appointment : availableAppoiments) {
            StringBuilder builder = new StringBuilder();
            builder.append("Cita ID: ");
            builder.append(appointment.getId());
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

        var consultation = new ConsulationEntity(this.database.newConsultations.size() + 1, availableAppoiments.get(appoimentId), LocalDate.parse(date));
        this.database.newConsultations.add(consultation);
        System.out.println("Consulta Registrada.");
    }
}
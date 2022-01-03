package com.kodigo.solid.services.auth;

import com.kodigo.solid.database.Database;
import com.kodigo.solid.entities.AppointmentEntity;
import com.kodigo.solid.entities.ConsulationEntity;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsultationService implements IConsultationService {
    private Database database = new Database();

    @Override
    public void showAll() {

        System.out.println("Consultas disponibles");

        var availableConsultations = this.database.newConsultations;
        for (ConsulationEntity consulation : availableConsultations) {
            System.out.println("Consulta ID: " + consulation.getId() + "FECHA: " + consulation.getConsultationDate());
        }
    }

    @Override
    public void createConsultation() {
        System.out.println("Citas disponibles");
        Scanner input = new Scanner(System.in);
        var availableAppoiments = this.database.getAppoiments();
        for (AppointmentEntity appointment : availableAppoiments) {
            System.out.println("\nCita ID: " + appointment.getPatientId() + "\nFECHA: " + appointment.getDate() + "\nHORA: " + appointment.getTime());
        }

        System.out.println("Ingrese Cita ID > ");
        int appoimentId = input.nextInt();
        System.out.println(availableAppoiments.get(appoimentId));
        System.out.println("Fecha que desea registrar la consulta (yyyy-mm-dd) > ");
        String date = input.nextLine();

        var consultation = new ConsulationEntity(1, availableAppoiments.get(appoimentId), LocalDate.parse(date));
        this.database.newConsultations.add(consultation);
        System.out.println("Consulta Registrada.");
    }
}

package com.kodigo.solid.entities;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentEntity implements Serializable {
    @Generated
    private int id;

    private Long idPatient;
    private String namePatient;
    private Long idDoctor;
    private String nameDoctor;
    private LocalTime time;
    private LocalDate datetime;
    Random random = new Random();

    public AppointmentEntity(int id, String name, String nameAuth, Long idAuth, LocalDate d, LocalTime t) {
        this.id = id;
        this.namePatient = name;
        this.nameDoctor = nameAuth;
        this.datetime = d;
        this.time = t;
        this.idDoctor = idAuth;

    }

    public AppointmentEntity(int id, LocalDate d, LocalTime t, String nameAuth, String name, Long idAuth) {
        this.id = id;
        this.datetime = d;
        this.time = t;
        this.namePatient = nameAuth;
        this.nameDoctor = name;
        this.idPatient = idAuth;
    }

    public String getDateString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy hh:mm:ss a");
        return datetime.format(formatter);
    }

    @Override
    public String toString() {
        return ("\nNumero cita: " + this.id +
                "\nNombre paciente: " + this.namePatient +
                "\nNombre doctor: " + nameDoctor +
                "\nFecha: " + this.datetime +
                "\nHora: " + this.time + "\n");
    }

}














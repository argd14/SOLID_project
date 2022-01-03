package com.kodigo.solid.entities;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Data
public class AppointmentEntity implements Serializable {
    @Getter
    private int id;
    @Getter
    private int patientId;
    @Getter
    private LocalDate date;
    @Getter
    private LocalTime time;
    private LocalDateTime datetime;

//  public AppointmentEntity(Entity<DoctorEntity> doctorInCharge, Entity<PatientEntity> patient)
//      throws IOException, ClassNotFoundException {
//    this.doctorInCharge = doctorInCharge;
//    this.patient = patient;
//    this.id = new AppoimentRepository(new AppoimentDataManagement()).count();
//  }

    public AppointmentEntity(int id, int patientId, LocalDate date, LocalTime time) {
        this.id = id;
        this.patientId = patientId;
        this.date = date;
        this.time = time;
        this.datetime = date.atTime(time);
    }

    public String getDateString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy hh:mm:ss a");
        return datetime.format(formatter);
    }

    @Override
    public String toString() {
        return ("Cita ID: " + this.id + ".\n" + "Paciente: " + this.patientId + ".\n" + "Fecha: " + this.getDateString());
    }

}














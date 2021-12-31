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
  private int id;
  private int patientId;
  private LocalDate date;
  private LocalTime time;
  private LocalDateTime datetime;

//  public AppointmentEntity(Entity<DoctorEntity> doctorInCharge, Entity<PatientEntity> patient)
//      throws IOException, ClassNotFoundException {
//    this.doctorInCharge = doctorInCharge;
//    this.patient = patient;
//    this.id = new AppoimentRepository(new AppoimentDataManagement()).count();
//  }

  public AppointmentEntity(int patientId, LocalDate date, LocalTime time)
  {
    this.patientId = patientId;
    this.date = date;
    this.time= time;
    this.datetime = date.atTime(time);
  }

  public String getDateString()
  {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy hh:mm:ss a");
    return datetime.format(formatter);
  }

  @Override
  public String toString()
  {
    return ("Cita ID: " + this.id + ".\n"  + "Paciente: " + this.patientId + ".\n" + "Fecha: " + this.getDateString());
  }

}














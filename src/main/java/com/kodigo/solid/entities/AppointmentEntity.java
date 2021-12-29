package com.kodigo.solid.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AppointmentEntity implements Serializable {
  //@Getter private int id;
  //@Getter private Entity<DoctorEntity> doctorInCharge;
  //@Getter private Entity<PatientEntity> patient;
  //@Getter
   public int patientId;
  //@Getter
  public LocalDate date;
  //@Getter
   public  LocalTime time;
  //@Getter
  public LocalDateTime datetime;


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

  public String getDate()
  {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy hh:mm:ss a");
    return datetime.format(formatter);
  }

  public LocalDateTime getDatetime()
  {
    return datetime;
  }

  @Override
  public String toString()
  {
    return ("Paciente: " + this.patientId + ".\n" + "Fecha: " + this.getDate());
  }

}














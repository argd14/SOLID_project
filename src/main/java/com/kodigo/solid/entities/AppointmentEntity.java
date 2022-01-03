package com.kodigo.solid.entities;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Data
public class AppointmentEntity implements Serializable {
  private int patientId;
  private LocalDate date;
  private LocalTime time;
  private LocalDateTime datetime;


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
    return ( "\nPaciente: " + this.patientId + ".\n" + "Fecha: " + this.getDateString());
  }

}














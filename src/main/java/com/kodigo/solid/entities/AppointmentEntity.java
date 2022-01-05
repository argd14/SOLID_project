package com.kodigo.solid.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
public class AppointmentEntity implements Serializable {
  private int Id;
  private LocalDate date;
  private LocalTime time;
  private LocalDateTime datetime;

  public AppointmentEntity(int id, LocalDate d, LocalTime t) {
    this.Id = id;
    this.date = d;
    this.time = t;
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
    return ( "\nPaciente: " + this.Id + ".\n" + "Fecha: " + this.getDateString());
  }

}














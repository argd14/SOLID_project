package com.kodigo.solid.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



public class AppointmentEntity extends BaseEntity implements Serializable {
  @Getter @Setter
  private LocalDate date;
  @Getter @Setter private LocalTime time;
  @Getter private LocalDateTime datetime;



  public AppointmentEntity(int id, LocalDate d, LocalTime t) {

    super(id);
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
  public String toString() {
    return "AppointmentEntity{" +

            "date=" + date +
            ", time=" + time +
            ", id=" + id +
            '}';
  }
}














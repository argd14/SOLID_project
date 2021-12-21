package com.kodigo.solid.entities;

import lombok.Getter;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class ConsultationEntity {
  private static final AtomicInteger count = new AtomicInteger(0);
  @Getter private int id;
  @Getter private AppointmentEntity appointmentPatient;

  @Getter private Date consultationDate;

  public ConsultationEntity(AppointmentEntity appointmentPatient, Date consultationDate) {
    this.appointmentPatient = appointmentPatient;
    this.consultationDate = consultationDate;
    this.id = count.incrementAndGet();
  }

  @Override
  public String toString() {
    return "ConsultationEntity{"
        + "id="
        + id
        + ", appointmentPatient="
        + appointmentPatient
        + ", consultationDate="
        + consultationDate
        + '}';
  }
}

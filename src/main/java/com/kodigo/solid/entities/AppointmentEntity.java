package com.kodigo.solid.entities;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

public class AppointmentEntity {
  private static final AtomicInteger count = new AtomicInteger(0);
  @Getter private int id;
  @Getter private DoctorEntity doctorInCharge;
  @Getter private PatientEntity patient;

  public AppointmentEntity(DoctorEntity doctorInCharge, PatientEntity patient) {
    this.doctorInCharge = doctorInCharge;
    this.patient = patient;
    this.id = count.incrementAndGet();
  }
}

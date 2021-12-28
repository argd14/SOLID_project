package com.kodigo.solid.entities;

import lombok.Getter;

public class AppointmentEntity implements Entity {
  @Getter private int id;
  @Getter private DoctorEntity doctorInCharge;
  @Getter private PatientEntity patient;

  public AppointmentEntity(DoctorEntity doctorInCharge, PatientEntity patient) {
    this.doctorInCharge = doctorInCharge;
    this.patient = patient;
    this.id = 1;
  }
}

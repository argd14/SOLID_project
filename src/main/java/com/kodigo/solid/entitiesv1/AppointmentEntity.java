package com.kodigo.solid.entitiesv1;

import lombok.Getter;

import java.io.Serializable;

public class AppointmentEntity extends BaseEntity implements Serializable {

  @Getter private Entity<DoctorEntity> doctorInCharge;
  @Getter private Entity<PatientEntity> patient;

  public AppointmentEntity(
      int id, Entity<DoctorEntity> doctorInCharge, Entity<PatientEntity> patient) {
    super(id);
    this.doctorInCharge = doctorInCharge;
    this.patient = patient;
  }

  @Override
  public String toString() {
    return "AppointmentEntity{"
        + "doctorInCharge="
        + doctorInCharge
        + ", patient="
        + patient
        + ", id="
        + id
        + '}';
  }
}

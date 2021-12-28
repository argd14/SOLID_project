package com.kodigo.solid.entities;

import com.kodigo.solid.data.fakedb.AppoimentDataManagement;
import com.kodigo.solid.data.repositories.AppoimentRepository;
import lombok.Getter;

import java.io.IOException;
import java.io.Serializable;

public class AppointmentEntity implements Entity, Serializable {
  @Getter private int id;
  @Getter private DoctorEntity doctorInCharge;
  @Getter private PatientEntity patient;

  public AppointmentEntity(DoctorEntity doctorInCharge, PatientEntity patient)
      throws IOException, ClassNotFoundException {
    this.doctorInCharge = doctorInCharge;
    this.patient = patient;
    this.id = new AppoimentRepository(new AppoimentDataManagement()).count();
  }
}

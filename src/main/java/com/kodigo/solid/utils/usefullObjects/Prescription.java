package com.kodigo.solid.utils.usefullObjects;

import com.kodigo.solid.entities.DoctorEntity;
import com.kodigo.solid.entities.PatientEntity;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Prescription {
  private static final AtomicInteger count = new AtomicInteger(0);
  @Getter private int id;
  @Getter private Date prescriptionDate;
  @Getter private DoctorEntity doctorInCharge;
  @Getter private PatientEntity patient;
  @Getter private List<Medicine> medicines;

  public Prescription(
      Date prescriptionDate,
      DoctorEntity doctorInCharge,
      PatientEntity patient,
      List<Medicine> medicines) {
    this.prescriptionDate = prescriptionDate;
    this.doctorInCharge = doctorInCharge;
    this.patient = patient;
    this.medicines = medicines;
    this.id = count.incrementAndGet();
  }

  @Override
  public String toString() {
    return "Prescription{"
        + "id="
        + id
        + ", prescriptionDate="
        + prescriptionDate
        + ", doctorInCharge="
        + doctorInCharge
        + ", patient="
        + patient
        + ", medicines="
        + medicines
        + '}';
  }
}

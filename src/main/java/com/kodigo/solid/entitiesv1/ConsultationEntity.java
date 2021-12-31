package com.kodigo.solid.entitiesv1;

import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;

public class ConsultationEntity extends BaseEntity implements Serializable {

  @Getter private Entity<AppointmentEntity> appointmentPatient;

  @Getter private LocalDate consultationDate;

  public ConsultationEntity(
      int id, Entity<AppointmentEntity> appointmentPatient, LocalDate consultationDate) {
    super(id);
    this.appointmentPatient = appointmentPatient;
    this.consultationDate = consultationDate;
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

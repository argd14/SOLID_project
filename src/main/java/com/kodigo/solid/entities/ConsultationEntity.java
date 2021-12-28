package com.kodigo.solid.entities;

import com.kodigo.solid.data.fakedb.ConsultationDataManagement;
import com.kodigo.solid.data.repositories.ConsultationRepository;
import lombok.Getter;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class ConsultationEntity implements Entity, Serializable {

  @Getter private int id;
  @Getter private Entity<AppointmentEntity> appointmentPatient;

  @Getter private LocalDate consultationDate;

  public ConsultationEntity(
      Entity<AppointmentEntity> appointmentPatient, LocalDate consultationDate)
      throws IOException, ClassNotFoundException {
    this.appointmentPatient = appointmentPatient;
    this.consultationDate = consultationDate;
    this.id = new ConsultationRepository(new ConsultationDataManagement()).count();
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

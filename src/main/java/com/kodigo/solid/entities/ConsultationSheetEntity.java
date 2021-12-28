package com.kodigo.solid.entities;

import com.kodigo.solid.data.fakedb.ConsultationDataManagement;
import com.kodigo.solid.data.repositories.ConsultationRepository;
import com.kodigo.solid.utils.usefullObjects.Prescription;
import lombok.Getter;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ConsultationSheetEntity implements Entity, Serializable {
  private static final AtomicInteger count = new AtomicInteger(0);
  @Getter private int id;
  @Getter private ConsultationEntity consultation;
  @Getter private Prescription prescription;
  @Getter private String diagnosis;
  @Getter private List<String> symptons;

  public ConsultationSheetEntity(
      ConsultationEntity consultation,
      Prescription prescription,
      String diagnosis,
      List<String> symptons)
      throws IOException, ClassNotFoundException {
    this.id = new ConsultationRepository(new ConsultationDataManagement()).count() + 1;
    this.consultation = consultation;
    this.prescription = prescription;
    this.diagnosis = diagnosis;
    this.symptons = symptons;
  }

  @Override
  public String toString() {
    return "ConsultationSheet{"
        + "id="
        + id
        + ", consultation="
        + consultation
        + ", prescription="
        + prescription
        + ", diagnosis='"
        + diagnosis
        + '\''
        + ", symptons="
        + symptons
        + '}';
  }
}

package com.kodigo.solid.entities;

import com.kodigo.solid.utils.usefullObjects.Prescription;
import lombok.Getter;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ConsultationSheetEntity implements Entity {
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
      List<String> symptons) {
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

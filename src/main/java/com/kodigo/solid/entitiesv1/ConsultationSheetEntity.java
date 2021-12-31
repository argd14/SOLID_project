package com.kodigo.solid.entitiesv1;

import com.kodigo.solid.utils.usefullObjects.Prescription;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

public class ConsultationSheetEntity extends BaseEntity implements Serializable {
  @Getter private ConsultationEntity consultation;
  @Getter private Prescription prescription;
  @Getter private String diagnosis;
  @Getter private List<String> symptons;

  public ConsultationSheetEntity(
      int id,
      ConsultationEntity consultation,
      Prescription prescription,
      String diagnosis,
      List<String> symptons) {
    super(id);
    this.consultation = consultation;
    this.prescription = prescription;
    this.diagnosis = diagnosis;
    this.symptons = symptons;
  }

  @Override
  public String toString() {
    return "ConsultationSheetEntity{"
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

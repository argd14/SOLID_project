package com.kodigo.solid.entitiesv1;

import java.io.Serializable;
import java.time.LocalDate;

public class PatientEntity extends UserEntity implements Serializable {
  public PatientEntity(
      int id, String name, LocalDate birthday, String phoneNumber, String email, String password) {
    super(id, name, birthday, phoneNumber, email, password);
  }

  @Override
  public String toString() {
    return "PatientEntity{" + "id=" + id + "}" + super.toString();
  }
}

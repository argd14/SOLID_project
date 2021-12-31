package com.kodigo.solid.entitiesv1;

import java.io.Serializable;
import java.time.LocalDate;

public class ReceptionistEntity extends UserEntity implements Serializable {

  public ReceptionistEntity(
      int id, String name, LocalDate birthday, String phoneNumber, String email, String password) {
    super(id, name, birthday, phoneNumber, email, password);
  }

  @Override
  public String toString() {
    return "ReceptionistEntity{" + "id=" + id + "}" + super.toString();
  }
}

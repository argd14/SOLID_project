package com.kodigo.solid.entitiesv1;

import java.io.Serializable;
import java.time.LocalDate;

public class DoctorEntity extends UserEntity implements Serializable {
  public DoctorEntity(
      int id, String name, LocalDate birthday, String phoneNumber, String email, String password) {
    super(id, name, birthday, phoneNumber, email, password);
  }
}

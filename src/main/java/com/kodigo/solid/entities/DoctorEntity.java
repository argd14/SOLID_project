package com.kodigo.solid.entities;

import com.kodigo.solid.utils.constants.MedicalSpecialties;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

public class DoctorEntity extends UserEntity implements Serializable {
  public boolean logged = false;
  @Getter private MedicalSpecialties specialty;

  public DoctorEntity(
      int id,
      String name,
      Date birthday,
      String phoneNumber,
      String email,
      String password,
      boolean logged,
      MedicalSpecialties specialty) {
    super(id, name, birthday, phoneNumber, email, password);
    this.logged = logged;
    this.specialty = specialty;
  }

  @Override
  public String toString() {
    return "DoctorEntity{" + "specialty=" + specialty + '}';
  }
}

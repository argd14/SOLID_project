package com.kodigo.solid.entities;

import com.kodigo.solid.utils.constants.MedicalSpecialties;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

public class DoctorEntity extends UserEntity implements Serializable {
  public boolean logged = false;
  @Getter private MedicalSpecialties specialty;

  public DoctorEntity(
      String name,
      Date birthday,
      String phoneNumber,
      String email,
      String password,
      MedicalSpecialties specialty) {
    super(name, birthday, phoneNumber, email, password);
    this.specialty = specialty;
  }

  @Override
  public String toString() {
    return "DoctorEntity{" + "specialty=" + specialty + '}';
  }
}

package com.kodigo.solid.entities;

import lombok.Getter;

import java.io.Serializable;
import java.util.Date;

public class PatientEntity extends UserEntity implements Entity, Serializable {
  @Getter private int id;
  @Getter private String gender;

  public PatientEntity(
      int id,
      String name,
      Date birthday,
      String phoneNumber,
      String email,
      String password,
      String gender) {
    super(name, birthday, phoneNumber, email, password);
    this.id = id;

    this.gender = gender;
  }

  @Override
  public String toString() {
    return super.toString() + "PatientEntity{" + "id=" + id + ", gender='" + gender + '\'' + '}';
  }
}

package com.kodigo.solid.entities;

import com.kodigo.solid.utils.usefullObjects.HomeAddress;
import lombok.Getter;

import java.util.Date;

public class PatientEntity extends UserEntity {
  @Getter private HomeAddress address;
  @Getter private String gender;

  public PatientEntity(
          String DUI,
      String name,
      String birthday,
      String phoneNumber,
      String email,
      String password,
      HomeAddress address,
      String gender) {
    super(DUI, name, birthday, phoneNumber, email, password);
    this.address = address;
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "PatientEntity{" + "address=" + address + ", gender='" + gender + '\'' + '}';
  }
}

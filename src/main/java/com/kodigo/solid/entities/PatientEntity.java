package com.kodigo.solid.entities;

import com.kodigo.solid.data.fakedb.PatientDataManagement;
import com.kodigo.solid.data.repositories.PatientRepository;
import lombok.Getter;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

public class PatientEntity extends UserEntity implements Entity, Serializable {
  @Getter private int id;
  @Getter private String gender;

  public PatientEntity(
      String name, Date birthday, String phoneNumber, String email, String password, String gender)
      throws IOException, ClassNotFoundException {
    super(name, birthday, phoneNumber, email, password);
    this.id = new PatientRepository(new PatientDataManagement()).count() + 1;

    this.gender = gender;
  }

  @Override
  public String toString() {
    return super.toString() + "PatientEntity{" + "id=" + id + ", gender='" + gender + '\'' + '}';
  }
}
